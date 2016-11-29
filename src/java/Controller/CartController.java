/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.CartDAO;
import dao.CartDAOImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author it353f608
 */
@ManagedBean(name = "CartController")
@SessionScoped
public class CartController {

    CartDAOImpl myDAO = new CartDAOImpl();
    /**
     * Creates a new instance of ShoppingController
     */
    public CartController() {
    }
    
    public void checkout()
    {
        
    }
}
