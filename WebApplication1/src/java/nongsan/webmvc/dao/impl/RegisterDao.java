package nongsan.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import nongsan.webmvc.model.User;
import nongsan.webmvc.jdbc.connectDB;

public class RegisterDao extends connectDB{


    public boolean RegisterUser(User user) {
        boolean set = false;
        try {
            String sql = "INSERT INTO users (username,password,email,phone,name,created) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getName());
            preparedStatement.setString(6, user.getCreated());
            preparedStatement.executeUpdate();

            set = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }
}
