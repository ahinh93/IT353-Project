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
public class ProfileController {

    private String response;
    private ProfileBean bean;

    public ProfileController() {
        bean = new ProfileBean();
    }

    public ProfileBean getProfileBean() {
        return bean;
    }

    public void setProfileBean(ProfileBean bean) {
        this.bean = bean;
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

    /**
     * @return the bean
     */
    public String createProfile() {
        ProfileDAO dao = new ProfileDAOImpl();    // Creating a new object each time.
        int rowCount = dao.createProfile(bean); // Doing anything with the object after this?
        if (rowCount == 1) {
            return "loggedIn.xhtml"; // navigate to "response.xhtml"
        } else {
            return "error.xhtml";
        }
    }
}
