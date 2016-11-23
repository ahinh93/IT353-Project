/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jesse
 */
public class Cart {
    private int cartUID;
    private String email;
    private int mediaID;

    public int getCartUID() {
        return cartUID;
    }

    public void setCartUID(int cartUID) {
        this.cartUID = cartUID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMediaID() {
        return mediaID;
    }

    public void setMediaID(int mediaID) {
        this.mediaID = mediaID;
    }
}
