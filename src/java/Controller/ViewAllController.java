package Controller;

import dao.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Media;

/**
 *
 * @author Jesse
 */
@ManagedBean
@SessionScoped
public class ViewAllController {
    private List images;
    private int rating;
    private int uid;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    public List getImages() {
        getAllImages();
        return images;
    }

    public void setImages(List images) {
        this.images = images;
    }
    
    public void getAllImages(){
        
        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
       String myDB = "jdbc:derby://localhost:1527/it353finalproject";
       String query = "select * from media";
      Connection DBConn = DBHelper.connect2DB(myDB, "admin1", "password");
     images = new ArrayList<Media>();
      try{
      
           Statement stmt = DBConn.createStatement();
           ResultSet rs = stmt.executeQuery(query);
           
           while(rs.next()){
              Media media = new Media(rs.getInt("uid"),rs.getString("url"),rs.getDouble("price"),
                      rs.getString("author"),rs.getInt("rating"));
              
              images.add(media);
           }
  
            rs.close();
            DBConn.close();
        } catch (Exception e) {
             System.err.println("Got an exception!");
             System.err.println(e.getMessage());
        } 
    }
   
    public void handleRating(int rating, String uid){
      System.out.println("handle rating called with rating: "+rating+" and uid of "+uid);
      if(rating==0)return;
      DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
      String myDB = "jdbc:derby://localhost:1527/it353finalproject";
      String query = "update media set rating = "+rating+" where uid = "+uid;
      Connection DBConn = DBHelper.connect2DB(myDB, "admin1", "password");
      
      try{
          Statement stmt = DBConn.createStatement();
          boolean result = stmt.execute(query);
          
          if(!result){
              throw new Exception();
          }
          
      }catch(Exception e){
          System.err.println("Got an exception");
          System.err.println(e.getMessage());
      }
     
      
    }
    
    
}
