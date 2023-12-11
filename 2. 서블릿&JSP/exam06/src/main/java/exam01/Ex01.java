package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex01 {
    public static void main(String[] args) throws ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "spring6";
        String password = "_aA123456";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(conn);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println();

        }
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
