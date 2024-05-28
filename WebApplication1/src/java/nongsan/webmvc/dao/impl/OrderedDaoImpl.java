package nongsan.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nongsan.webmvc.dao.OrderedDao;
import nongsan.webmvc.model.Ordered;
import nongsan.webmvc.jdbc.connectDB;

public class OrderedDaoImpl extends connectDB implements OrderedDao {

    @Override
    public void insert(Ordered ordered) {
        String sql = "INSERT INTO ordered(product_id, transaction_id, qty) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(ordered.getProduct_id()));
            ps.setInt(2, Integer.parseInt(ordered.getTransaction_id()));
            ps.setInt(3, ordered.getQty());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Ordered ordered) {
        String sql = "UPDATE ordered SET product_id = ?, transaction_id = ?, qty = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(ordered.getProduct_id()));
            ps.setInt(2, Integer.parseInt(ordered.getTransaction_id()));
            ps.setInt(3, ordered.getQty());
            ps.setInt(4, Integer.parseInt(ordered.getId()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM ordered WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ordered get(int id) {
        String sql = "SELECT * FROM ordered WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Ordered ordered = new Ordered();
                ordered.setId(rs.getString("id"));
                ordered.setProduct_id(rs.getString("product_id"));
                ordered.setTransacsion_id(rs.getString("transaction_id"));
                ordered.setQty(rs.getInt("qty"));
                return ordered;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Ordered get(String name) {
        // This method is not used in this implementation
        return null;
    }

    @Override
    public List<Ordered> getAll() {
        List<Ordered> ordereds = new ArrayList<>();
        String sql = "SELECT * FROM ordered";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ordered ordered = new Ordered();
                ordered.setId(rs.getString("id"));
                ordered.setProduct_id(rs.getString("product_id"));
                ordered.setTransacsion_id(rs.getString("transaction_id"));
                ordered.setQty(rs.getInt("qty"));
                ordereds.add(ordered);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordereds;
    }
}
