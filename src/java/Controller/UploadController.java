/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.DBHelper;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import model.User;



/**
 *
 * @author Jesse
 */
@ManagedBean
@SessionScoped
public class UploadController {
    private String response;
    private Part media;
    private String latestID;
    
    private String price;
    private String tags;

    @ManagedProperty("#{loginController}")
    private LoginController lc;

    public LoginController getLc() {
        return lc;
    }

    public void setLc(LoginController lc) {
        this.lc = lc;
    }
    
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLatestID() {
        latestID="";
        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
       String myDB = "jdbc:derby://localhost:1527/it353finalproject";
       String query = "select * from media";
      Connection DBConn = DBHelper.connect2DB(myDB, "admin1", "password");
      
      try{
      
           Statement stmt = DBConn.createStatement();
           ResultSet rs = stmt.executeQuery(query);
           
           while(rs.next()){
              latestID =""+ rs.getInt("uid");
           }
       
            rs.close();
            DBConn.close();
        } catch (Exception e) {
             System.err.println("Got an exception!");
             System.err.println(e.getMessage());
        }
         return latestID;
    }
    public void setLatestID(String latestID) {
        this.latestID = latestID;
    }

    public UploadController(){
        
    }
    
    public String upload(){
        
        System.out.println("price: "+price);
        System.out.println("tags: "+tags);
//        if(user == null){
//            return "failedupload.xhtml";
//        }
       DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
       String myDB = "jdbc:derby://localhost:1527/it353finalproject";
       String query = "insert into media (url, price, author, tags)"
        + " values (?, ?, ?, ?)";
      Connection DBConn = DBHelper.connect2DB(myDB, "admin1", "password");
      
      try{
      
            PreparedStatement preparedStmt = DBConn.prepareStatement(query);
           
            preparedStmt.setDouble (2, Double.parseDouble(price));
            preparedStmt.setString (3, lc.getEmail());
            preparedStmt.setString(4, tags);
       
            InputStream inputStream = null; // input stream of the upload file
            
            if(media != null){
                // obtains input stream of the upload file
                inputStream = media.getInputStream();
            }
            
            if (inputStream != null) {
//                // fetches input stream of the upload file for the blob column
                preparedStmt.setBlob(1, inputStream);
            }
            
            
            // execute the preparedstatement
            preparedStmt.execute();
       
            
            DBConn.close();
        } catch (Exception e) {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
      return "failedupload.xhtml";
    }
      return "successfulupload.xhtml";
 }
  
    
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Part getMedia() {
        return media;
    }

    public void setMedia(Part media) {
        this.media = media;
    }
     
   
}