/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrarydao;

import DVDLibrarydto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author kmlnd
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    public static final String DVD_FILE = "dvds.txt";
    public static final String DELIMITER = "::";
    
    
    private Map<String, DVD> dvds = new HashMap<>();
    
    private void loadDVDS() throws DVDLibraryDaoException {
        Scanner scanner;
        
        //start of dvd
        
        try {
            //create scanner for reading file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_FILE)));
            } catch (FileNotFoundException e) {
	        throw new DVDLibraryDaoException(
	                "-_- Could not load roster data into memory.", e);
	    }
            // currentLine holds the most recent line read from the file
	    String currentLine;
            String[] currentTokens;
            
            
              while (scanner.hasNextLine()) {
	        // get the next line in the file
	        currentLine = scanner.nextLine();
	        // break up the line into tokens
	        currentTokens = currentLine.split(DELIMITER);
	        // Create a new DVD object and put it into the map
	  
	        DVD currentDVD = new DVD(currentTokens[0]);
	        // Set the remaining vlaues on currentStudent manually
	        currentDVD.setReleaseDate(currentTokens[1]);
	        currentDVD.setDirectorsName(currentTokens[2]);
	        currentDVD.setStudio(currentTokens[3]);
                currentDVD.setUserRatingOrNote(currentTokens[4]);
                
                // Put currentDVD into the map Title as the key
	        dvds.put(currentDVD.getTitle(), currentDVD);
        }
            // close scanner
	    scanner.close();
    }
    
    
    //end of load dvd
    

    @Override
    public DVD addDVD(String Title, DVD dvd) throws DVDLibraryDaoException{
        DVD newDVD = dvds.put(Title,dvd);
        loadDVDS();
        return newDVD;
       
    }

    @Override
    public DVD removeDVD(String Title) throws DVDLibraryDaoException {
        DVD removeDVD = dvds.remove(Title);
        loadDVDS();
        return removeDVD;
    }

    //may not work will fix if doesnt l8r
    public DVD editDVD(String Title,DVD dvd) {
        dvds.remove(Title);
        DVD newDVD = dvds.put(Title,dvd);
        return newDVD;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> displayAllDVDs()throws DVDLibraryDaoException {
        loadDVDS();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD searchDVD(String Title) throws DVDLibraryDaoException {
        loadDVDS();
        return dvds.get(Title);
    }

    @Override
    public DVD showInfo(String Title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD editDVD(String Title, String ReleaseDate, String MPAArating, String DirectorsName, String Studio, String UserRatingOrNote) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
