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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCatMovie {

    private SQLServerDataSource ds;

    public DAOCatMovie() {
        ds = new SQLServerDataSource();
        ds.setDatabaseName("RedbullMovCol");
        ds.setUser("CSe19B_2");
        ds.setPassword("CSe19B_2");
        ds.setServerName("10.176.111.31");
        ds.setPortNumber(1433);
    }
    
    //Method that receives a category ID, performs a Join table that allows to get movies by category and returns a list of movies that match the received category ID
    
    public List<Movie> DisplayOnlyMoviesInCategory (int catId) {
        
         try (Connection con = ds.getConnection()) {
            List<Movie> movieLst = new ArrayList();
            String sql = "SELECT Movies.name,personalRating,imdbrating FROM MOVIES \n"+
                    "JOIN CatMovie ON Movies.id = CatMovie.movieId \n"+
                    "JOIN Category ON Category.id = CatMovie.categoryId \n"+
                    "WHERE categoryId = ? Order by Movies.id";
           
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, catId);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                
                String name = rs.getString("name");
                float personalRating = rs.getFloat("personalRating");
                float imdbrating = rs.getFloat("imdbrating");
                Movie movie = new Movie(name, personalRating,imdbrating);
                movieLst.add(movie);
            }
              return movieLst;

       } catch (SQLServerException sqlse) {
            Logger.getLogger(DAOCatMovie.class.getName()).log(Level.SEVERE, null, sqlse);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCatMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
    
    //Method that adds into the table Catmovie a movieId and categoryId so that these two values are associated to each other.
    //this method is used when creating a new movie so that it has one or multiple categories.
    public void addToCatMovie(int movieId, int categoryId){
        
         try (Connection con = ds.getConnection()) {
            String sql = "INSERT INTO CatMovie (movieId, categoryId) values (?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, movieId);
            pstmt.setInt(2, categoryId);
            pstmt.executeUpdate();

        } catch (SQLServerException ex) {
            Logger.getLogger(DAOCatMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCatMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
