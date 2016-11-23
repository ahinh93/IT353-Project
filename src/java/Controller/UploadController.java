/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;
import model.Media;



/**
 *
 * @author Jesse
 */
@ManagedBean
@SessionScoped
public class UploadController {
    private String response;
    private Media media;

    public UploadController(){
        media = new Media();
    }
    
    
    
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
     
   
}