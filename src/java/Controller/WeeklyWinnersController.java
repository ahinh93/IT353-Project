/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.WeeklyWinnersDAOImpl;
import java.util.ArrayList;
import java.util.List;
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
    
    private WeeklyWinners winner;
    private ArrayList<WeeklyWinners> winners;
    private String payoutTo;
    private List<WeeklyWinners> listsAvailDates;

    public List<WeeklyWinners> getListsAvailDates() {
        if(winners == null || winners.isEmpty()){
            getWinners();
        }
        listsAvailDates = new ArrayList<WeeklyWinners>();
        for(WeeklyWinners weekWin : winners){
            if(!weekWin.isBeenpaid()){
                listsAvailDates.add(weekWin);
            }
        }
        
        return listsAvailDates;
    }

    public void setListsAvailDates(List<WeeklyWinners> listsAvailDates) {
        this.listsAvailDates = listsAvailDates;
    }

    public String getPayoutTo() {
        return payoutTo;
    }

    public void setPayoutTo(String payoutTo) {
        this.payoutTo = payoutTo;
    }

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
    

    public String payoutWinner(){
        
        if(payoutTo == null){
            return "failedupload.xhtml";
        }
        
        
        
        
        
        return "failedupload.xhtml";
    }
}