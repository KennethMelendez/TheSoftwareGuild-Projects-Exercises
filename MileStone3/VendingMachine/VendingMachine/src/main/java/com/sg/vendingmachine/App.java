/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.VendingMachineController;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoInMemImpl;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Currency;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOInMemImpl;
import com.sg.vendingmachine.ui.VendingMachineView;

/**
 *
 * @author kmlnd
 */
public class App {

    public static void main(String[] args) {

        //INJECTION
        UserIO io = new UserIOInMemImpl();
        Change currency = new Change();
        VendingMachineView view = new VendingMachineView(io,currency);
        VendingMachineDao dao = new VendingMachineDaoInMemImpl();
        VendingMachineController controller = new VendingMachineController(view,dao);
        controller.run();
        
       
        /*============================================
              _________________________
              |                       |
              |    VENDING MACHINE    |
              |_______________________|
        
        ============================================*/
    }
}


