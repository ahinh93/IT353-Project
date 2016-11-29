/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Cart;
/**
 *
 * @author it353f608
 */
public interface CartDAO {
    public int createCart();
    public Cart getCartById(int id);
}
