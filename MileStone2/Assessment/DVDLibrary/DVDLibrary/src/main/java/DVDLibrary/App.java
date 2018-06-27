/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary;

import DVDLibraryController.DVDLibraryController;
import DVDLibrarydao.DVDLibraryDao;
import DVDLibrarydao.DVDLibraryDaoException;
import DVDLibrarydao.DVDLibraryDaoFileImpl;
import DVDLibraryui.DVDLibraryView;
import DVDLibraryui.UserIO;
import DVDLibraryui.UserIOConsoleImpl;

/**
 *
 * @author kmlnd
 */
public class App {
    public static void main(String[] args) throws DVDLibraryDaoException {
        //change 
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        
        
        
        DVDLibraryController controller = 
                new DVDLibraryController(myDao,myView);
        controller.run();
        
        
    }
}
