package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.*;

/**
 * @author Randall DeVitto
 */
public class DashDAOImpl implements DashDAO {
    
    private final String driverName = "org.apache.derby.jdbc.ClientDriver";
    private final String connStr = "jdbc:derby://localhost:1527/it353finalproject";
    
    public DashDAOImpl() { 
    }
    
    @Override
    public String getPassword(String email) {
        Connection DBConn = null;
        String result = "";
        
        try {
            DBHelper.loadDriver(driverName);
            DBConn = DBHelper.connect2DB(connStr, "admin1", "password");
            String query = "SELECT password FROM it353finalproject.users WHERE email = ?";
            PreparedStatement stmt = DBConn.prepareStatement(query);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            result = rs.getString("password");
            
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
        return result;
    }   

    @Override
    public int updateUser(User userBean) {
        return 0;
    }
    
    @Override
    public ArrayList<WeeklyWinners> getAllWinners() {
        String query = "SELECT * FROM weeklywinners ORDER BY date DESC";
        ArrayList<WeeklyWinners> winners = new ArrayList<WeeklyWinners>();
        Connection DBConn = null;
        WeeklyWinners winner = null;
        
        try {
            DBHelper.loadDriver(driverName);
            DBConn = DBHelper.connect2DB(connStr, "admin1", "password");
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            Date date; int winnerid; boolean paid;
            while (rs.next()) {
                date = rs.getDate("win_date");
                winnerid = rs.getInt("winner_media_id");
                paid = rs.getBoolean("beenpaid");
                
                winner = new WeeklyWinners(date,winnerid,paid);
                //getAuthorsForWinners(winner, winnerid);
                winners.add(winner);
            }
            
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
        return winners;
    }
    
    @Override
    public WeeklyWinners getWinner(String UID) {
        return null;
    }
}
