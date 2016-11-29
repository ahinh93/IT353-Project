/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.WeeklyWinners;

/**
 *
 * @author Jesse
 */
public class WeeklyWinnersDAOImpl implements WeeklyWinnersDAO{

    @Override
    public ArrayList<WeeklyWinners> findAllWinners() {
    
        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/it353finalproject";
        String query = "select * from weeklywinners";
        Connection DBConn = DBHelper.connect2DB(myDB,"admin1","password");
        
        ArrayList<WeeklyWinners> allWinners = new ArrayList<WeeklyWinners>();
        WeeklyWinners winner = null;
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Date date;
            int winnerid;
            boolean paid;
            
            while(rs.next()){
                date = rs.getDate("win_date");
                winnerid = rs.getInt("winner_media_id");
                paid = rs.getBoolean("beenpaid");
                
                winner = new WeeklyWinners(date,winnerid,paid);
                allWinners.add(winner);
            }
            rs.close();
            stmt.close();
            
        }catch(Exception e){
            System.err.println("Error: Problem with SQL.");
            e.printStackTrace();
        }
        return allWinners;
    }

    @Override
    public void payout(WeeklyWinners winner) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
