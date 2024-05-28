package nongsan.webmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nongsan.webmvc.jdbc.connectDB;
import nongsan.webmvc.model.Admin;

public class AdminLoginDao {
    public static boolean checkAdminLogin(String username, String password) {
        boolean exist = false;
        try {
            String sql = "SELECT * FROM admin WHERE username=? AND password=?";
            connectDB db = new connectDB();
            Connection con = db.connection;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            exist = rs.next();
            if (exist) {
                Admin admin = new Admin();
                String name = rs.getString("name");
                admin.setName(name);
                // Các thao tác khác với dữ liệu admin nếu cần
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }
}
