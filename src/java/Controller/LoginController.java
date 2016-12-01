/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.ProfileDAO;
import dao.ProfileDAOImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ProfileBean;

/**
 *
 * @author it353F629
 */

@ManagedBean
@SessionScoped
public class LoginController {
    private ProfileBean profile;
    private String email;
    private String password;
    private String response;
    private int row = 0;

    public LoginController()
    {
        profile = new ProfileBean();
    }
    /**
     * @return the profile
     */
    public ProfileBean getProfile() {
        return profile;
    }

    /**
     * @param profile the profile to set
     */
    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }
    
    public String findUserEmail()
    {
        ProfileDAO dao = new ProfileDAOImpl();       
        profile = dao.findUserEmail(email, password);
        
        if(profile != null)
        {
            return "loggedIn.xhtml";
        }
        else
        {
            response = "FAILED LOG IN.";          
            return "logIn.xhtml";
        }
    }
    
}
