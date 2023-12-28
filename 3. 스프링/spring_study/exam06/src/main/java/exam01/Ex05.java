package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex05 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "spring6";
        String password = "_aA123456";

        try(Connection conn = DriverManager.getConnection(url, username, password)){

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println();
        }
    }
}
