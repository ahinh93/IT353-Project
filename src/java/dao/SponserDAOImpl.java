package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Randall DeVitto
 */
public class SponserDAOImpl implements SponserDAO {

    @Override
    public int updateSponsers(String sponser) {
        return 0;
    }

    @Override
    public String getSponsers() {
        Connection DBConn = null;
        String sponserList = "a";
        
        try {
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            String myDB = "jdbc:derby://localhost:1527/it353finalproject";
            DBConn = DBHelper.connect2DB(myDB, "admin1", "password");

            String query = "SELECT URL_LIST from ADMIN1.SPONSERS";
            
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);  
            
            while(rs.next() != false)
                sponserList = rs.getString("url_list");
            
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }

        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return sponserList;
    }
}
