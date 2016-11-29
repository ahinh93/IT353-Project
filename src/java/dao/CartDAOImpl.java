/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Cart;

/**
 *
 * @author Jesse
 */
public class CartDAOImpl implements CartDAO{

    @Override
    public int createCart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cart getCartById(int id) {
        String query = "select * from it353finalproject.cart where cart_uid = "+ id;
        
        Cart aCart;
        try{
            aCart = loadCartFromDB(query);
        }catch(Exception e){
            aCart = new Cart();
        }
        return aCart;

    }
    
    private static Cart loadCartFromDB(String query){
        DBHelper.loadDriver("org.aoache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/it353finalproject";
        Connection DBConn = DBHelper.connect2DB(myDB, "admin1", "password");
        
        Cart aCart = null;
        
        try{
            
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int uid, mediaID;
            String email;
            while(rs.next()){
                uid = rs.getInt("cartUID");
                email = rs.getString("email");
                mediaID = rs.getInt("mediaID");
                
                aCart = new Cart(uid,email,mediaID);              
            }
            rs.close();
            stmt.close();
        } catch (Exception e){
            System.err.println("Error: Problem with the SQL select");
            e.printStackTrace();
        }
        try{
            DBConn.close();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return aCart;
    }
    
}
