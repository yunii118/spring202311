package config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@MapperScan("mapper")
public class DbConfig {
    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        DataSource ds = new DataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        ds.setUsername("spring6");
        ds.setPassword("aA123456");

        // connection pool 설정
        ds.setInitialSize(2);
        ds.setTestWhileIdle(true); // 유휴 상태 커넥션 객체를 체크할지 여부 //
        ds.setTimeBetweenEvictionRunsMillis(3000);
        ds.setMinEvictableIdleTimeMillis(30 * 1000);

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());

        return sessionFactoryBean.getObject();
    }
    @Bean
    public PlatformTransactionManager transactionManager(){
        DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource());

        return tm;
    }
}

