/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.dal;

import FindYourFavs.be.Movie;
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

public class DAOMovie {

    private SQLServerDataSource ds;
    // set up connection to the Database
    public DAOMovie() {
        ds = new SQLServerDataSource();
        ds.setDatabaseName("RedbullMovCol");
        ds.setUser("CSe19B_2");
        ds.setPassword("CSe19B_2");
        ds.setServerName("10.176.111.31");
        ds.setPortNumber(1433);
    }
    //Method that returns from database all the movies from the Movies table into a list
    public List<Movie> getAllMovies() {
        
        try (Connection con = ds.getConnection()) {
            String sql = "SELECT id, name, personalRating, IMDBRating,filelink, imdbbrowser, lastview FROM Movies";
            List<Movie> movieLst = new ArrayList();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float personalRating = rs.getFloat("personalRating");
                float IMDBRating = rs.getFloat("IMDBRating");
                String filelink = rs.getString("filelink");
                String imdbbrowser = rs.getString("imdbbrowser");
                int lastView = rs.getInt("lastview");

                Movie movie = new Movie(id, name, personalRating, IMDBRating, filelink, lastView, imdbbrowser);
                movieLst.add(movie);
            }
            return movieLst;
        } catch (SQLServerException sqlse) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, sqlse);
        } catch (SQLException ex) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    // Method that recieves a movie object and its properties and adds it to the database inside the Movies table
 /*   public void addMovie(int id, String name, int personalRating, int IMDBRating, String fileLink, int lastView) {

        try (Connection con = ds.getConnection()) {
            String sql = "INSERT INTO Movies (name,personalRating,IMDBRating,fileLink,lastView) values (?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setFloat(2, personalRating);
            pstmt.setFloat(3, IMDBRating);
            pstmt.setString(4, fileLink);
            pstmt.setInt(5, lastView);
            pstmt.executeUpdate();

        } catch (SQLServerException ex) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
    */
  //Method that recieves an Id and deletes the movie that matches that Id in the Movies Table of the Database
    public void deleteMovieById(int id) {
        try ( Connection con = ds.getConnection()) {
            String sql = "DELETE FROM Movies WHERE id = ? ";
            String sql2 = "DELETE FROM CatMovie Where movieId = ? ";

            PreparedStatement p = con.prepareStatement(sql);
            PreparedStatement p2 = con.prepareStatement(sql2);
            p.setInt(1, id);
            p2.setInt(1, id);
            p.executeUpdate();
            p2.executeUpdate();

        } catch (SQLServerException ex) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addMovie(String name, float personalrating, float imdbrating, int lastview, String filelink, String imdbbrowser) {
        
        try (Connection con = ds.getConnection()) {
            String sql = "INSERT INTO Movies (name, personalrating, imdbrating, lastview, filelink,imdbbrowser) values (?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setFloat(2, personalrating);
            pstmt.setFloat(3, imdbrating);
            pstmt.setInt(4, lastview);
            pstmt.setString(5, filelink);
            pstmt.setString(6, imdbbrowser);
            pstmt.executeUpdate();

        } catch (SQLServerException ex) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Movie> AlertData() {

        try (Connection con = ds.getConnection()) {
            String sql = "SELECT name,personalRating,lastview FROM Movies WHERE personalRating<6 AND lastview<2018";
            List<Movie> movieLst = new ArrayList();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                String name = rs.getString("name");
                float personalRating = rs.getFloat("personalRating");
                int lastview = rs.getInt("lastview");

                Movie movie = new Movie(name, personalRating, lastview, " ");
                movieLst.add(movie);
            }
            return movieLst;
        } catch (SQLServerException sqlse) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, sqlse);
        } catch (SQLException ex) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void addNewUsrRating(int idOfMovie, String newUsrRating) {
        
        try (Connection con = ds.getConnection()) {
            String sql = "UPDATE Movies SET personalrating = ? WHERE id = ? ";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, newUsrRating);
            pstmt.setInt(2, idOfMovie);
            pstmt.executeUpdate();

        } catch (SQLServerException sqlse) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, sqlse);
        } catch (SQLException ex) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Movie> getAllMoviesWithFilter(String filterText) {
        
        try (Connection con = ds.getConnection()) {
            
            List<Movie> allMovies = new ArrayList<>();
            String sql = "SELECT * FROM Movies WHERE name LIKE ? ";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%" + filterText + "%");

            ResultSet ds = pstmt.executeQuery();
            while (ds.next()) {
                int id = ds.getInt("id");
                String name = ds.getString("name");
                float personalrating = ds.getFloat("personalrating");
                float imdbrating = ds.getFloat("imdbrating");
                String filelink = ds.getString("filelink");
                int lastview = ds.getInt("lastview");
                Movie movie = new Movie(id, name, personalrating, imdbrating, filelink, lastview);
                allMovies.add(movie);
            }
            return allMovies;
        } catch (SQLServerException ex) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Movie> getFilteredMoviesByIMDB(String filterText) {
        
        try (Connection con = ds.getConnection()) {

            List<Movie> allMovies = new ArrayList<>();
            String sql = "SELECT * FROM Movies WHERE imdbrating >= ? ";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, filterText);

            ResultSet ds = pstmt.executeQuery();
            while (ds.next()) {
                int id = ds.getInt("id");
                String name = ds.getString("name");
                float personalrating = ds.getFloat("personalrating");
                float imdbrating = ds.getFloat("imdbrating");
                String filelink = ds.getString("filelink");
                int lastview = ds.getInt("lastview");
                Movie movie = new Movie(id, name, personalrating, imdbrating, filelink, lastview);
                allMovies.add(movie);
            }
            return allMovies;
        } catch (SQLServerException ex) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
