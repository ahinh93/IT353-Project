/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.WeeklyWinners;

/**
 *
 * @author Jesse
 */
public class WeeklyWinnersDAOImpl implements WeeklyWinnersDAO{

    @Override
    public ArrayList<WeeklyWinners> findAllWinners() {
    
        return null;
    }

    @Override
    public void payout(WeeklyWinners winner) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
