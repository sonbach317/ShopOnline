package nongsan.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nongsan.webmvc.dao.BoardnewDao;
import nongsan.webmvc.model.Boardnew;
import nongsan.webmvc.jdbc.connectDB; // Ensure this import is correct based on your project structure

public class BoardnewDaoImpl extends connectDB implements BoardnewDao {

    @Override
    public void insert(Boardnew boardnew) {
        String sql = "INSERT INTO boardnew(title, content, image_link, author, created) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, boardnew.getTitle());
            ps.setString(2, boardnew.getContent());
            ps.setString(3, boardnew.getImage_link());
            ps.setString(4, boardnew.getAuthor());
            ps.setString(5, boardnew.getCreated());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM boardnew WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Boardnew boardnew) {
        String sql = "UPDATE boardnew SET title=?, content=?, image_link=?, author=?, created=? WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, boardnew.getTitle());
            ps.setString(2, boardnew.getContent());
            ps.setString(3, boardnew.getImage_link());
            ps.setString(4, boardnew.getAuthor());
            ps.setString(5, boardnew.getCreated());
            ps.setInt(6, Integer.parseInt(boardnew.getId())); // assuming `id` is stored as a String, we convert it to int
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boardnew get(int id) {
        String sql = "SELECT * FROM boardnew WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Boardnew boardnew = new Boardnew();
                boardnew.setId(rs.getString("id"));
                boardnew.setTitle(rs.getString("title"));
                boardnew.setContent(rs.getString("content"));
                boardnew.setImage_link(rs.getString("image_link"));
                boardnew.setAuthor(rs.getString("author"));
                boardnew.setCreated(rs.getString("created"));
                return boardnew;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boardnew get(String name) {
        // Implement if necessary
        return null;
    }

    @Override
    public List<Boardnew> getAll() {
        List<Boardnew> boardnews = new ArrayList<>();
        String sql = "SELECT * FROM boardnew";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Boardnew boardnew = new Boardnew();
                boardnew.setId(rs.getString("id"));
                boardnew.setTitle(rs.getString("title"));
                boardnew.setContent(rs.getString("content"));
                boardnew.setImage_link(rs.getString("image_link"));
                boardnew.setAuthor(rs.getString("author"));
                boardnew.setCreated(rs.getString("created"));
                boardnews.add(boardnew);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boardnews;
    }
}
