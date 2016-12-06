package Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.*;
import dao.*;
import java.util.ArrayList;
import javax.faces.bean.ManagedProperty;

/**
 * @author Randall DeVitto
 */
@ManagedBean
@SessionScoped
public class DashboardController {
    //Class Variables
    private User userBean; 
    private final DashDAO dao = new DashDAOImpl();      
    
    //Page Variables
    private WeeklyWinners[] pastWinners = new WeeklyWinners[5];
    private WeeklyWinners[] currentWinners = new WeeklyWinners[5];
    private boolean loggedIn = false;
    private String inputToken;
    private String response;
    private String userName;
    private String sponsers = "";
    @ManagedProperty("#{loginController}")
    private LoginController lc;

    public LoginController getLc() {
        return lc;
    }

    public void setLc(LoginController lc) {
        this.lc = lc;
    }
    
    public DashboardController() {
    }

    public String login() {
        this.loggedIn = true;
        return "dashboard.xhtml";
    }
    
    public String logout() {
        lc.killProfile();
        this.loggedIn = false;
        return "index.xhtml";
    }
    
    public void getWinners() {
        ArrayList<WeeklyWinners> list = dao.getAllWinners();

        //sort past winners and recent winners by dates. Split the array
        //and sort the lower half as past and upper as current. Use a SQL
        //sort by DESC.
//        System.arraycopy(list, 0, currentWinners, 0, currentWinners.length);
//        System.arraycopy(list, currentWinners.length, 
//                pastWinners, 0, pastWinners.length);
    }
    
    public void addSponser() {
        SponserDAO dao = new SponserDAOImpl();
        int status = dao.updateSponsers(sponser);
        
        if(status == 200)
            response = "Sponsers Updated";
        else
            response = "Error: Sponser Update Failed";
        
        //In the DAO, SELECT the current value, concat that value with inputToken, 
        //then UPDATE the value in the database
    }
    
    private String retrieveSponsersList() {
        SponserDAO dao = new SponserDAOImpl();
        setSponser(dao.getSponsers());
        return sponser;
    }
    
    public String retrievePassword() {
        DashDAO dao = new DashDAOImpl();
        return dao.getPassword(inputToken);
    }    
    
    //--------------------------------------------------

    public User getUserBean() {
        return userBean;
    }
 
    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }    

    public WeeklyWinners[] getPastWinners() {
        return pastWinners;
    }

    public void setPastWinners(WeeklyWinners[] pastWinners) {
        this.pastWinners = pastWinners;
    }
    
    public WeeklyWinners[] getCurrentWinners() {
        return currentWinners;
    }

    public void setCurrentWinners(WeeklyWinners[] currentWinners) {
        this.currentWinners = currentWinners;
    }

    public String getInputToken() {
        return inputToken;
    }

    public void setInputToken(String inputToken) {
        this.inputToken = inputToken;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

<<<<<<< HEAD
    public String getUsername() {
        return "Hello Test Name";
=======
    public String getUserName() {
        return "Hello " + lc.getEmail();
>>>>>>> d1a89442fc82cd3fde3df97ffa68bac49af49f83
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getSponser() {
        return retrieveSponsersList();
    }

    public void setSponser(String sponser) {
        this.sponser = sponser;
    }
    
   
}