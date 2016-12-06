/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.CartDAO;
import dao.CartDAOImpl;
import dao.DBHelper;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Cart;

/**
 *
 * @author it353f608
 */ 
@ManagedBean(name = "CartController")
@SessionScoped
public class CartController {

    @ManagedProperty("#{loginController}")
    private LoginController lc;
    private ArrayList<Cart> myCart;    
    CartDAOImpl myDAO = new CartDAOImpl();
    
    /**
     * Creates a new instance of ShoppingController
     */
    public CartController() {
        
        myCart = new ArrayList<Cart>();
    }
    
    public LoginController getLc() {
        return lc;
    }
    
    public int addToCart()
    {
        String mediaID = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("mediaIDkey");
        System.out.println("Adding media: " + mediaID +" to the cart table");
        return 1;
    }    
    /**
     * TODO:
     * 1.insert all entries with that email into a string array and double array
     * 2.pass arrays into email controller --> emailReceipt(media_id,price)
     * 3.delete entries from database
     * @return 
     */
    public String checkout()
    {
        System.out.println("@@@@@@@@@@"+lc.getEmail()+" just hit the checkout button");
        //insert media id's and prices to arrays
        ArrayList<Integer> media_ids = new ArrayList<Integer>();
        ArrayList<Double> prices = new ArrayList<Double>();
        
        
        
        
        //email user receipt
        prepareReceipt(media_ids,prices);
        
        //email author for royalty
        //prepareRoyalty();
        
        //remove from database
        return deleteFromCartTable();
    }
    public void prepareReceipt(ArrayList<Integer> ids, ArrayList<Double> prices)
    {        
        //create controller and call its email method
        EmailController ec = new EmailController();
        ec.emailReceipt(lc.getEmail(), ids, prices);
    }
    public String deleteFromCartTable()
    {
        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/it353finalproject";
        //DELETE FROM CART WHERE email = 'ahinh@ilstu.edu' and media_id = 202;
        String query = "DELETE FROM CART WHERE EMAIL = ?";
        System.out.println("query: " + query);
        Connection DBConn = DBHelper.connect2DB(myDB, "admin1", "password");

        try{
      
            PreparedStatement preparedStmt = DBConn.prepareStatement(query);
            preparedStmt.setString (1, lc.getEmail());
            // execute the preparedstatement
            preparedStmt.execute();
            DBConn.close();


            //send royalty to artist

            } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return "failedpurchase.xhtml";
        }
        return "successfulcheckout.xhtml";
    }
    public void setLc(LoginController lc) {
        this.lc = lc;
    }
    /**
     * @return the myCart
     */
    public ArrayList<Cart> getMyCart() {
        CartDAOImpl daoImp = new CartDAOImpl();
        
        this.myCart = daoImp.getCartByEmail(lc.getEmail());
        return myCart;
    }

    /**
     * @param myCart the myCart to set
     */
    public void setMyCart(ArrayList<Cart> myCart) {
        this.myCart = myCart;
    }     
    
}
