/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindYourFavs.dal;
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
    
}