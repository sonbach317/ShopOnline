package nongsan.webmvc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connectDB {
//	public connectDB(){
//		super();
//	}
        public Connection connection;
//	public static Connection getConnect(){
//		Connection connection = null;
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;user=sa;password=123;useUnicode=true;characterEncoding=UTF-8");
//			System.out.println("Kết nối thành công!");
//		} catch (SQLException | ClassNotFoundException e) {
//			System.out.println("Kết nối thất bại!"+e.getMessage());
//		}
//		return connection;
//	}
//	public static void main(String[] args) {
//		System.out.println(getConnect());
//	}
        public connectDB() {
        try {
            String url = "jdbc:mysql://localhost:3306/qlns";
            String username = "root";
            String password = "123456"; // Thay doi tren tung may
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}