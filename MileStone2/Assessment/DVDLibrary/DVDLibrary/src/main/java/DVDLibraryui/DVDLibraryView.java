/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibraryui;

import DVDLibrarydto.DVD;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public class DVDLibraryView {
    UserIO io;
    
    public DVDLibraryView(UserIO io){
        this.io = io;
    }
    
    public int printMenuAndGetSelection(){
        
            io.print("Main Menu");
            io.print("1. Add a DVD to the Collection");
            io.print("2. Remove a DVD from the Collection");
            io.print("3. Edit the information for an existing DVD in the Collection");
            io.print("4. List the DVDs in the Collection");
            io.print("5. Display the information for a particular DVD");
            io.print("6. Search DVD by Title");
            io.print("7. Exit");
            
            return io.readInt("Please select from the"
	                    + " above choices.", 1, 7);
            
        
    }
    
    public DVD getNewDVDInfo(){
        String DVDtitle = io.readString("Please Enter DVD Title");
        String DVDreleaseDate = io.readString("Please Enter DVD Release Date");
        String MPAArating = io.readString("Please Enter MPAA rating");
        String DirectorsName = io.readString("Please Enter Directors Name");
        String Studio = io.readString("Please Enter Studio");
        String UserRatingOrNote = io.readString("Please Enter User Rating or Note");
        DVD currentDVD = new DVD(DVDtitle);
        currentDVD.setReleaseDate(DVDreleaseDate);
        currentDVD.setMPAArating(MPAArating);
        currentDVD.setDirectorsName(DirectorsName);
        currentDVD.setStudio(Studio);
        currentDVD.setUserRatingOrNote(UserRatingOrNote);
        return currentDVD;
    }
    
    	public void displayCreateDVDBanner() {
	    io.print("=== Create DVD ===");
	}
        
        public void displayCreateSuccessDVD() {
	    io.readString(
	            "DVD successfully created.  Please hit enter to continue");
	}
        
        public void displayDVDList(List<DVD> dvds){
            for(DVD currentDVDS : dvds){
                io.print(currentDVDS.getTitle() + ": "
                        + currentDVDS.getReleaseDate());
            }
        }
        
        public void displayAllBanner(){
            io.print("=== Display All DVDS ===");
        }    
        
        public void displayDVDBanner(){
            io.print("==Display DVD==");
        }
        
        public String getDVDChoice(){
            return io.readString("Please Enter the DVD Title.");
        }
        
        public void displayDVD(DVD dvds){
            if(dvds != null){
                io.print(dvds.getTitle());
                io.print(dvds.getReleaseDate());
                io.print(dvds.getMPAArating());
                io.print(dvds.getDirectorsName());
                io.print(dvds.getStudio());
                io.print(dvds.getUserRatingOrNote());
                io.print("");
            } else{
                io.print("No such DVD.");
            }
            io.print("Please hit enter to continue");
        }
        
        //added delete if doesnt work
        public void displayDVDInfo(DVD dvds){
            if(dvds != null){
                io.print(dvds.getUserRatingOrNote());
                io.print("");
            } else{
                io.print("No such DVD.");
            }
            io.print("Please hit enter to continue");
        }
        
        public void displayDVDRemovesBanner(){
            io.print("==Remove DVD==");
        }
        
        public void displayRemoveSuccessBanner(){
            io.readString("DVD successfully removed. Please hit enter to continue.");
        }
        
        
        public void displayExitBanner(){
            io.print("Good Bye!!!");
        }
        
        public void displayUnknownCommandBanner(){
            io.print("Unknown Command!!!");
        }
        
        public void displayErrorMessage(String errorMsg) {
            io.print("=== ERROR ===");
            io.print(errorMsg);
        }
        
}
