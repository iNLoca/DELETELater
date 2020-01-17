/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.dal;

import FindYourFavs.be.Category;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCategory {

    private SQLServerDataSource ds;

    public DAOCategory() {
        ds = new SQLServerDataSource();
        ds.setDatabaseName("RedbullMovCol");
        ds.setUser("CSe19B_2");
        ds.setPassword("CSe19B_2");
        ds.setServerName("10.176.111.31");
        ds.setPortNumber(1433);
    }
//Method that retrieves all the categories from the Categories table and returns a List of category Type
    public List<Category> getAllCategories() {

        try ( Connection con = ds.getConnection()) {
            String sql = "SELECT id, name FROM Category";
            List<Category> categoryLst = new ArrayList();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Category category = new Category(id, name);
                categoryLst.add(category);
            }
            return categoryLst;
        } catch (SQLServerException sqlse) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, sqlse);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//Method that recieves an ID from a category and performs the Delete command on SQL to the category that matches that ID
    public void deleteCategoryById(int id) {

        try ( Connection con = ds.getConnection()) {
            String sql = "DELETE FROM Category WHERE id=?";
            PreparedStatement p = con.prepareStatement(sql);

            p.setInt(1, id);
            p.executeUpdate();

        } catch (SQLServerException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Method that recieves a string as a name of the category and adds it to the category database
    public void addCategory(String name) {
        
        try (Connection con = ds.getConnection()) {
            String sql = "INSERT INTO Category (name) values (?)";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.executeUpdate();

        } catch (SQLServerException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
