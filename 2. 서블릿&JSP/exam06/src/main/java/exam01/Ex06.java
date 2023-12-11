package exam01;

import java.sql.*;

public class Ex06 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "spring6";
        String password = "_aA123456";

        String sql = "SELECT * FROM MEMBER";
        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();){
            while(rs.next()){
                String userNo = rs.getString(1);
                String userId = rs.getString(2);
                String userPw = rs.getString(3);
                String userNm =  rs.getString(4);
                String email = rs.getString(5);

                System.out.println(userNo + userId + userPw + userNm + email);
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println();
        }


    }
}
