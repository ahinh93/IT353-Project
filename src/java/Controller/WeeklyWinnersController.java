/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.WeeklyWinnersDAOImpl;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.WeeklyWinners;

/**
 *
 * @author Jesse
 */
@ManagedBean
@SessionScoped
public class WeeklyWinnersController {
    
    WeeklyWinners winner;
    ArrayList winners;

    public ArrayList<WeeklyWinners> getWinners() {
        WeeklyWinnersDAOImpl daoImp = new WeeklyWinnersDAOImpl();
        
        this.winners = daoImp.findAllWinners();
        return winners;
    }

    public WeeklyWinners getWinner() {
        return winner;
    }

    public void setWinner(WeeklyWinners winner) {
        this.winner = winner;
    }
        
    public WeeklyWinnersController(){
        winner = new WeeklyWinners();
    }
}
