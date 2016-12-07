/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ProfileBean;

/**
 *
 * @author it353F629
 */
public class ProfileDAOImpl implements ProfileDAO {

    @Override
    public int createProfile(ProfileBean bean) {
        int rowCount = 0;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        try {
            
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/jalltop_Fa2016_it353finalproject";
            Connection DBConn = DriverManager.getConnection(myDB, "admin1", "password");
            String insertString;
            Statement stmt = DBConn.createStatement();

            //fixed vaerified
            insertString = "INSERT INTO ADMIN1.USERS (email, password, fullname, subscribed, userlevel, phonenumber) VALUES ('"
                    + bean.getEmail()
                    + "','" + bean.getPassword()
                    + "','" + bean.getFullname()
                    + "','" + bean.getSubscribed()
                    + "','" + bean.getUserlevel()
                    + "','" + bean.getPhoneNo()
                     + "')";
            
            rowCount = stmt.executeUpdate(insertString);
            System.out.println("insert string =" + insertString);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        //Call mail class to send email verification
        return rowCount;
    }
    
    @Override
    public int updateProfile(ProfileBean bean)
    {
        int rowCount = 0;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        try {
            
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/jalltop_Fa2016_it353finalproject";
            Connection DBConn = DriverManager.getConnection(myDB, "admin1", "password");
            String insertString;
            Statement stmt = DBConn.createStatement();

            insertString = "UPDATE ADMIN1.USERS SET "
                    + "password = '" + bean.getPassword() + "', "
                    + "fullname = '" + bean.getFullname() + "', "
                    + "phonenumber = '" + bean.getPhoneNo()+ "', "
                    + "subscribed = '" + bean.getSubscribed()+ "' "
                    + "userlevel = '" + bean.getUserlevel()+ "' "
                    + "WHERE email = '" + bean.getEmail()+ "'";
            
            rowCount = stmt.executeUpdate(insertString);
            System.out.println("insert string =" + insertString);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }       
        return rowCount;
    }

    private ProfileBean retrieveAccount(String query) {
        Connection DBConn = null;
        ProfileBean bean = new ProfileBean();
        try {
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/jalltop_Fa2016_it353finalproject";
            DBConn = DBHelper.connect2DB(myDB, "admin1", "password");

            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String email, password, fullname, phoneNo, subscribed, userlevel;
            boolean verified;
            System.out.print("Starting retrieval");
            while (rs.next()) {
                email = rs.getString("email");
                password = rs.getString("password");
                fullname = rs.getString("fullname");
                subscribed = rs.getString("subscribed");
                userlevel = rs.getString("userlevel");
                phoneNo = rs.getString("phonenumber");
                verified = rs.getBoolean("verified");
                
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@email: " +email +"\npassword: "+ password);
                

                bean = new ProfileBean(email, password, fullname, phoneNo, subscribed, userlevel);
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
        return bean;
    }
    
    @Override
    public ProfileBean findUserEmail(String email, String password) {
        String query = "SELECT * FROM USERS WHERE email = '" + email + "'" + " AND password = " + "'" + password +"'";
        return retrieveAccount(query);
    }

    public ArrayList findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList findByName(String aName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
