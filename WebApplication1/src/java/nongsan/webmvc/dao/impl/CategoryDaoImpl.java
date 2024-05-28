package nongsan.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nongsan.webmvc.dao.CategoryDao;
import nongsan.webmvc.model.Catalog;
import nongsan.webmvc.jdbc.connectDB; // Ensure this import is correct based on your project structure

public class CategoryDaoImpl extends connectDB implements CategoryDao {

    @Override
    public void insert(Catalog category) {
        String sql = "INSERT INTO catalog(name, parent_id) VALUES (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setString(2, category.getParent_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Catalog category) {
        String sql = "UPDATE catalog SET name = ?, parent_id = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setString(2, category.getParent_id());
            ps.setString(3, category.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Catalog get(int id) {
        String sql = "SELECT * FROM catalog WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Catalog category = new Catalog();
                category.setId(rs.getString("id"));
                category.setName(rs.getString("name"));
                category.setParent_id(rs.getString("parent_id"));
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Catalog get(String name) {
        // Implement if necessary
        return null;
    }

    @Override
    public List<Catalog> getAll() {
        List<Catalog> categories = new ArrayList<>();
        String sql = "SELECT * FROM catalog";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Catalog category = new Catalog();
                category.setId(rs.getString("id"));
                category.setName(rs.getString("name"));
                category.setParent_id(rs.getString("parent_id"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM catalog WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Catalog> getCateByProduct(int id) {
        List<Catalog> products_cate = new ArrayList<>();
        String sql = "SELECT catalog.name FROM catalog, product WHERE catalog.id = product.catalog_id AND product.id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Catalog catagory_product = new Catalog();
                catagory_product.setName(rs.getString("name"));
                products_cate.add(catagory_product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products_cate;
    }
}
