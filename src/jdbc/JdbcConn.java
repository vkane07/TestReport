package jdbc;

import java.sql.*;

public class JdbcConn {
    private static String url =  "jdbc:mysql://119.29.202.214:3306/report?useUnicode=true&characterEncoding=utf-8";
    private static String user = "root";
    private static String password = "a123456";

    public static Connection conn = null;
    public static PreparedStatement ps;
    public static ResultSet rs;
    public static Statement st;

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = JdbcConn.getConnection();
        if(conn != null){
            System.out.println("数据库连接正常");
        }else {
            System.out.println("数据库连接异常！");
        }
    }
}
