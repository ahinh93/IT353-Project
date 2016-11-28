/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
    private Part media;

    public UploadController(){
        
    }
    
    public void upload(){
       DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
       String myDB = "jdbc:derby://localhost:1527/it353finalproject";
       String query = "insert into media (url, price, author)"
        + " values (?, ?, ?)";
      Connection DBConn = DBHelper.connect2DB(myDB, "admin1", "password");
      
      try{
      
            PreparedStatement preparedStmt = DBConn.prepareStatement(query);
            preparedStmt.setString (1, "http://www.google.com");
            preparedStmt.setDouble (2, 100.00);
            preparedStmt.setString (3, "jalltop@ilstu.edu");
       
            // execute the preparedstatement
            preparedStmt.execute();
       
               DBConn.close();
        } catch (Exception e) {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
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