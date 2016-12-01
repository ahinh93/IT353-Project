package Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.*;
import dao.*;
import java.util.ArrayList;

/**
 * @author Randall DeVitto
 */
@ManagedBean
@SessionScoped
public class DashboardController {
    private User userBean; 
    private final DashDAO dao = new DashDAOImpl();      
    private WeeklyWinners[] pastWinners = new WeeklyWinners[5];
    private WeeklyWinners[] currentWinners = new WeeklyWinners[5];
    private boolean loggedIn = false;
    private String searchToken;
    private String response;    
    
    public DashboardController() {
    }

    public String login() {
        this.loggedIn = true;
        return "dashboard.xhtml";
    }
    
    public String logout() {
        this.loggedIn = false;
        return "index.xhtml";
    }
    
    public String updateProfile() {
        int status = dao.updateUser(userBean);
        if(status == 200) {
            setResponse("Profile was successfully updated");
            return response;
        } else {
            setResponse("Error while updating profile");
            return response;
        }
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
    
    public String retrievePassword() {
        return dao.getPassword(searchToken);
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

    public String getSearchTerm() {
        return searchToken;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchToken = searchTerm;
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
}