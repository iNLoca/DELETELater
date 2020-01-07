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

}
