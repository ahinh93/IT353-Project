/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.CartDAO;
import dao.CartDAOImpl;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Cart;

/**
 *
 * @author it353f608
 */
@ManagedBean(name = "CartController")
@SessionScoped
public class CartController {

    private ArrayList<Cart> myCart;
    
    CartDAOImpl myDAO = new CartDAOImpl();
    /**
     * Creates a new instance of ShoppingController
     */
    public CartController() {
        
        myCart = new ArrayList<Cart>();
    }
    
    public void checkout()
    {
        
    }

    /**
     * @return the myCart
     */
    public ArrayList<Cart> getMyCart() {
        CartDAOImpl daoImp = new CartDAOImpl();
        
        this.myCart = daoImp.getCartByEmail("ahinh@ilstu.edu");
        return myCart;
    }

    /**
     * @param myCart the myCart to set
     */
    public void setMyCart(ArrayList<Cart> myCart) {
        this.myCart = myCart;
    }
}
