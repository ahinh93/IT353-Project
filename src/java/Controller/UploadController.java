/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;



/**
 *
 * @author Jesse
 */
@ManagedBean
@SessionScoped
public class UploadController {
   private Part file;

   public void upload(){
       
   }
   
   
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
}