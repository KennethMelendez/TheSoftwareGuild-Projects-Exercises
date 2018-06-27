/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibraryController;

import DVDLibrarydao.DVDLibraryDao;
import DVDLibrarydao.DVDLibraryDaoException;
import DVDLibrarydao.DVDLibraryDaoFileImpl;
import DVDLibrarydto.DVD;
import DVDLibraryui.DVDLibraryView;
import DVDLibraryui.UserIO;
import DVDLibraryui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public class DVDLibraryController {
    
    DVDLibraryView view;
    DVDLibraryDao dao;
    
    //changed for depency injection
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view){
        this.dao = dao;
        this.view = view;
    }

 
   
    
    public void run() throws DVDLibraryDaoException {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
        
        while (keepGoing) {

            menuSelection = getMenuSelection();
            
            switch (menuSelection) {
                case 1:
                    //add dvd
                    createDVD();
                    break;
                case 2:
                    //remove dvd
                    removeDVD();
                    break;
                case 3:
                    //edit info =========================Last one
                    editDVD();
                    break;
                case 4:
                    //LIST DVDS
                    listDVDS();
                    break;
                case 5:
                    //dvd info or notes
                    info();
                    break;
                case 6:
                    //search dvd
                    viewDVD();
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
                    
            }
        }
        exitMessage();
        
        } catch (DVDLibraryDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    	    private int getMenuSelection() {
	        return view.printMenuAndGetSelection();
	    }
            
            private void createDVD() throws DVDLibraryDaoException{
                view.displayCreateDVDBanner();
                DVD newDVD = view.getNewDVDInfo();
                dao.addDVD(newDVD.getTitle(), newDVD);
                view.displayCreateSuccessDVD();
            }
            
            private void listDVDS() throws DVDLibraryDaoException{
                view.displayAllBanner();
                List<DVD> dvds = dao.displayAllDVDs();
                view.displayDVDList(dvds);
            }
            
            private void viewDVD() throws DVDLibraryDaoException{
                view.displayDVDBanner();
                String DVDChoice = view.getDVDChoice();
                DVD dvds = dao.searchDVD(DVDChoice);
                view.displayDVD(dvds);
            }
            
            private void info() throws DVDLibraryDaoException{
                view.displayDVDBanner();
                String DVDChoice = view.getDVDChoice();
                DVD dvds = dao.searchDVD(DVDChoice);
                view.displayDVDInfo(dvds);
            }
            
            private void removeDVD() throws DVDLibraryDaoException{
                view.displayDVDRemovesBanner();
                String DVDtitle = view.getDVDChoice();
                dao.removeDVD(DVDtitle);
                view.displayRemoveSuccessBanner();
            }
            
            private void editDVD() throws DVDLibraryDaoException{
                view.displayDVDRemovesBanner();
                String DVDtitle = view.getDVDChoice();
                dao.removeDVD(DVDtitle);
                view.displayRemoveSuccessBanner();
                view.displayCreateDVDBanner();
                DVD newDVD = view.getNewDVDInfo();
                dao.addDVD(newDVD.getTitle(), newDVD);
                view.displayCreateSuccessDVD();
                
            }
            
            private void unknownCommand(){
                view.displayUnknownCommandBanner();
            }
            
            private void exitMessage(){
                view.displayExitBanner();
            }
            

}
