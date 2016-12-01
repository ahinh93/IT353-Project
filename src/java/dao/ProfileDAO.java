/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.ProfileBean;

/**
 *
 * @author it353F629
 */
public interface ProfileDAO {

    public int createProfile(ProfileBean dao);
    
    public int updateProfile(ProfileBean dao);

    public ProfileBean findUserEmail(String email, String password);
    //public ArrayList findAll();

    //public ArrayList findByName(String aName); // either get one back or several if multiple same name allowed  

    

}
