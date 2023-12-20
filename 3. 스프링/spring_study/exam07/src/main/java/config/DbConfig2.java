package config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration

public class DbConfig2 {
    @Profile("dev")
    @Configuration
    @MapperScan("mapper")
    @EnableTransactionManagement
    static class DbDevConfig{
        // 개발
        @Bean(destroyMethod = "close")
        public DataSource dataSource() {
            System.out.println("dev profile");
            DataSource ds = new DataSource();
            /* 연결 설정 */
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
            ds.setUsername("SPRING6");
            ds.setPassword("_aA123456");

            /* 커넥션 풀 설정 */
            ds.setInitialSize(2);
            ds.setMaxActive(10);
            ds.setTestWhileIdle(true);


            return ds;
        }

        @Bean
        public PlatformTransactionManager transactionManager() {
            return new DataSourceTransactionManager(dataSource());
        }

        @Bean
        public SqlSessionFactory sqlSessionFactory() throws Exception {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(dataSource());

            return sessionFactoryBean.getObject();
        }
    }
    @Profile("prod")
    @Configuration
    @MapperScan("mapper")
    @EnableTransactionManagement
    static class DbProdConfig{
        // 프로덕션, 실제 배포했을때

        @Bean(destroyMethod = "close")
        public DataSource dataSource() {
            System.out.println("prod profile");
            DataSource ds = new DataSource();
            /* 연결 설정 */
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
            ds.setUsername("SPRING6");
            ds.setPassword("_aA123456");

            /* 커넥션 풀 설정 */
            ds.setInitialSize(2);
            ds.setMaxActive(10);
            ds.setTestWhileIdle(true);


            return ds;
        }

        @Bean
        public PlatformTransactionManager transactionManager() {
            return new DataSourceTransactionManager(dataSource());
        }

        @Bean
        public SqlSessionFactory sqlSessionFactory() throws Exception {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(dataSource());

            return sessionFactoryBean.getObject();
        }
    }
}
