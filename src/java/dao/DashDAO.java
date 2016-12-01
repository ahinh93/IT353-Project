package dao;

//import java.util.Date;
import java.util.ArrayList;
import model.*;

/**
 * @author Randall DeVitto
 */
public interface DashDAO {
    public String getPassword(String userEmail);
    public int updateUser(User userBean);
    public ArrayList<WeeklyWinners> getAllWinners();   //date is to filter current winners
    public WeeklyWinners getWinner(String userEmail);
}
