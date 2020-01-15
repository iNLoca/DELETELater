/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.dal;

import FindYourFavs.be.Category;
import FindYourFavs.be.Movie;
import FindYourFavs.bll.Manager;
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

public class DAL {

    private SQLServerDataSource ds;

    public DAL() {
        ds = new SQLServerDataSource();
        ds.setDatabaseName("RedbullMovCol");
        ds.setUser("CSe19B_2");
        ds.setPassword("CSe19B_2");
        ds.setServerName("10.176.111.31");
        ds.setPortNumber(1433);
    }

    public List<Movie> getAllMovies() {
        try ( Connection con = ds.getConnection()) {
            String sql = "SELECT id,name,personalRating,IMDBRating FROM Movies";
            List<Movie> movieLst = new ArrayList();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int personalRating = rs.getInt("personalRating");
                int IMDBRating = rs.getInt("IMDBRating");
                Movie movie = new Movie(id, name, personalRating, IMDBRating);
                movieLst.add(movie);
            }
            return movieLst;
        } catch (SQLServerException sqlse) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, sqlse);
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Category> getAllCategories() {
        try ( Connection con = ds.getConnection()) {
            String sql = "SELECT id, name FROM Category";
            List<Category> categoryLst = new ArrayList();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Category category = new Category (id, name);
                categoryLst.add(category);
            }
            return categoryLst;
        } catch (SQLServerException sqlse) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, sqlse);
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    public void addMovie(int id, String name, int personalRating, int IMDBRating, String fileLink, int lastView) {

        try ( Connection con = ds.getConnection()) {
            String sql = "INSERT INTO Movies (name,personalRating,IMDBRating,fileLink,lastView) values (?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setInt(2, personalRating);
            pstmt.setInt(3, IMDBRating);
            pstmt.setString(4, fileLink);
            pstmt.setInt(5, lastView);
            pstmt.executeUpdate();

        } catch (SQLServerException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addCategory(int id, String name) {

        try ( Connection con = ds.getConnection()) {
            String sql = "INSERT INTO Category (name)(?)";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.executeUpdate();

        } catch (SQLServerException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addPersonalRating(int id, int rating) {

        try ( Connection con = ds.getConnection()) {
            String sql = "INSERT INTO Movies (personalrating) values (?)";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, rating);
            pstmt.executeUpdate();

        } catch (SQLServerException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteMovieById(int id) {
        try ( Connection con = ds.getConnection()) {
            String sql = "DELETE FROM Movies WHERE id=?";
            PreparedStatement p = con.prepareStatement(sql);

            p.setInt(1, id);
            p.executeUpdate();

        } catch (SQLServerException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteCategoryById(int id) {
        try ( Connection con = ds.getConnection()) {
            String sql = "DELETE FROM Category WHERE id=?";
            PreparedStatement p = con.prepareStatement(sql);

            p.setInt(1, id);
            p.executeUpdate();

        } catch (SQLServerException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addCategory(String name) {
       try ( Connection con = ds.getConnection()) {
            String sql = "INSERT INTO Category (name) values (?)";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.executeUpdate();

        } catch (SQLServerException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addMovie(String name, int personalrating, int imdbrating, int lastview, String filelink){
         try ( Connection con = ds.getConnection()) {
            String sql = "INSERT INTO Movies (name, personalrating, imdbrating, lastview, filelink) values (?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, name);
            pstmt.setInt(2, personalrating);
            pstmt.setInt(3, imdbrating);
            pstmt.setInt(4, lastview);
            pstmt.setString(5, filelink);
            pstmt.executeUpdate();

        } catch (SQLServerException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Movie>AlertData(){
    
         try ( Connection con = ds.getConnection()) {
            String sql = "SELECT name,personalRating,lastview FROM Movies WHERE personalRating<6 AND lastview<2018";
            List<Movie> movieLst = new ArrayList();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                
                String name = rs.getString("name");
                int personalRating = rs.getInt("personalRating");
                int lastview = rs.getInt("lastview");
                
                Movie movie = new Movie(name, personalRating,lastview);
                movieLst.add(movie);
            }
            return movieLst;
        } catch (SQLServerException sqlse) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, sqlse);
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    
    }
    public void addNewUsrRating(int idOfMovie, String newUsrRating) {
         try ( Connection con = ds.getConnection()) {
            String sql = "UPDATE Movies SET personalrating = ? WHERE id = ? ";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, newUsrRating);
            pstmt.setInt(2,idOfMovie);
            pstmt.executeUpdate();

       } catch (SQLServerException sqlse) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, sqlse);
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
       
}
    public List<Movie> getAllMoviesWithFilter(String filterText) {
        try ( Connection con = ds.getConnection()) {

            List<Movie> allMovies = new ArrayList<>();
            String sql = "SELECT * FROM Movies WHERE name LIKE ? ";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%" + filterText + "%");

            ResultSet ds = pstmt.executeQuery();
            while (ds.next()) {
                int id = ds.getInt("id");
                String name = ds.getString("name");
                int personalrating = ds.getInt("personalrating");
                int imdbrating = ds.getInt("imdbrating");
                String filelink = ds.getString("filelink");
                int lastview = ds.getInt("lastview");
                Movie movie = new Movie(id, name, personalrating, imdbrating, filelink, lastview);
                allMovies.add(movie);
            }
            return allMovies;
        } catch (SQLServerException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
 /*   public List<Category> getMoviesByCategory() {
        try (Connection con = ds.getConnection()) {
            String sql = "SELECT id, name FROM Category";
            List<Category> categoryLst = new ArrayList();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Category category = new Category (id, name);
                categoryLst.add(category);
            }
            return categoryLst;
        } catch (SQLServerException sqlse) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, sqlse);
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }*/
    
    }
        

   
