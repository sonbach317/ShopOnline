package nongsan.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nongsan.webmvc.dao.TransactionDao;
import nongsan.webmvc.model.Transactions;
import nongsan.webmvc.jdbc.connectDB;

public class TransactionDaoImpl extends connectDB implements TransactionDao {

    @Override
    public void insert(Transactions transaction) {
        String sql = "INSERT INTO transactions(user_session, user_name, user_mail, user_phone, address, message, amount, payment, created) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, transaction.getUser_session());
            ps.setString(2, transaction.getUser_name());
            ps.setString(3, transaction.getUser_mail());
            ps.setString(4, transaction.getUser_phone());
            ps.setString(5, transaction.getAddress());
            ps.setString(6, transaction.getMessage());
            ps.setString(7, transaction.getAmount());
            ps.setString(8, transaction.getPayment());
            ps.setString(9, transaction.getCreated());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM transactions WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Transactions get(int id) {
        String sql = "SELECT * FROM transactions WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Transactions transaction = new Transactions();
                transaction.setId(rs.getInt("id"));
                transaction.setUser_session(rs.getString("user_session"));
                transaction.setUser_name(rs.getString("user_name"));
                transaction.setUser_mail(rs.getString("user_mail"));
                transaction.setUser_phone(rs.getString("user_phone"));
                transaction.setAddress(rs.getString("address"));
                transaction.setMessage(rs.getString("message"));
                transaction.setAmount(rs.getString("amount"));
                transaction.setPayment(rs.getString("payment"));
                transaction.setCreated(rs.getString("created"));
                return transaction;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void edit(Transactions transaction) {
        String sql = "UPDATE transactions SET user_name = ?, user_mail = ?, user_phone = ?, address = ?, message = ?, amount = ?, payment = ?, status = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, transaction.getUser_name());
            ps.setString(2, transaction.getUser_mail());
            ps.setString(3, transaction.getUser_phone());
            ps.setString(4, transaction.getAddress());
            ps.setString(5, transaction.getMessage());
            ps.setString(6, transaction.getAmount());
            ps.setString(7, transaction.getPayment());
            ps.setString(8, transaction.getStatus());
            ps.setInt(9, transaction.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Transactions get(String name) {
        return null;
    }

    @Override
    public List<Transactions> getAll() {
        List<Transactions> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Transactions transaction = new Transactions();
                transaction.setId(rs.getInt("id"));
                transaction.setUser_session(rs.getString("user_session"));
                transaction.setUser_name(rs.getString("user_name"));
                transaction.setUser_mail(rs.getString("user_mail"));
                transaction.setUser_phone(rs.getString("user_phone"));
                transaction.setAddress(rs.getString("address"));
                transaction.setMessage(rs.getString("message"));
                transaction.setAmount(rs.getString("amount"));
                transaction.setPayment(rs.getString("payment"));
                transaction.setStatus(rs.getString("status"));
                transaction.setCreated(rs.getString("created"));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
