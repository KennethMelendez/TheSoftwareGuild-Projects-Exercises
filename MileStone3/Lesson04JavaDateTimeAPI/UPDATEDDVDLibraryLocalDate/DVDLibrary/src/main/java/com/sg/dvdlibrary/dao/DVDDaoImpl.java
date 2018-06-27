/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author kmlnd
 */
public class DVDDaoImpl implements DVDDao {

    Map<String, DVD> library = new HashMap<>();
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    @Override
    public DVD addDVD(String Title, DVD dvd) throws DVDLibraryDaoException {
        
        DVD newDVD = library.put(Title, dvd);
        writeDvds();
        return newDVD;
    }

    @Override
    public List<DVD> ListDVDS() throws DVDLibraryDaoException{
        loadDvds();
        return new ArrayList<DVD>(library.values());
    }

    @Override
    public DVD getDVD(String Title) throws DVDLibraryDaoException{
        loadDvds();
        return library.get(Title);
    }

    @Override
    public DVD removeDVD(String Title) throws DVDLibraryDaoException {
        DVD dvds = library.remove(Title);
        writeDvds();
        return dvds;
    }

    private void loadDvds() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER
        // NOTE FOR APPRENTICES: In our case we use :: as our delimiter.  If
        // currentLine looks like this:
        // 1234::Joe::Smith::Java-September2013
        // then currentTokens will be a string array that looks like this:
        //
        // ___________________________________
        // |    |   |     |                  |
        // |1234|Joe|Smith|Java-September2013|
        // |    |   |     |                  |
        // -----------------------------------
        //  [0]  [1]  [2]         [3]
        String[] currentTokens;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Student object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // Create a new Student object and put it into the map of students
            // NOTE FOR APPRENTICES: We are going to use the student id
            // which is currentTokens[0] as the map key for our student object.
            // We also have to pass the student id into the Student constructor
            DVD dvds = new DVD();
            // Set the remaining vlaues on currentStudent manually
            dvds.setTitle(currentTokens[0]);
            dvds.setTitle(currentTokens[1]);
            dvds.setReleaseDate(currentTokens[2]);
            dvds.setMPAArating(currentTokens[3]);
            dvds.setDirectorsName(currentTokens[4]);
            dvds.setStudio(currentTokens[5]);
            dvds.setUserRatingOrNote(currentTokens[6]);

            // Put currentStudent into the map using studentID as the key
            dvds.put(dvds, dvds.getTitle());
        }
        // close scanner
        scanner.close();
    }
    
    	/**
	 * Writes all students in the roster out to a ROSTER_FILE.  See loadRoster
	 * for file format.
	 * 
	 * @throws ClassRosterDaoException if an error occurs writing to the file
	 */
	private void writeDvds() throws DVDLibraryDaoException {
	    // NOTE FOR APPRENTICES: We are not handling the IOException - but
	    // we are translating it to an application specific exception and 
	    // then simple throwing it (i.e. 'reporting' it) to the code that
	    // called us.  It is the responsibility of the calling code to 
	    // handle any errors that occur.
	    PrintWriter out;
	    
	    try {
	        out = new PrintWriter(new FileWriter(ROSTER_FILE));
	    } catch (IOException e) {
	        throw new DVDLibraryDaoException(
	                "Could not save student data.", e);
	    }
	    
	    // Write out the Student objects to the roster file.
	    // NOTE TO THE APPRENTICES: We could just grab the student map,
	    // get the Collection of Students and iterate over them but we've
	    // already created a method that gets a List of Students so
	    // we'll reuse it.
	    List<DVD> dvds = this.ListDVDS();
	    for (DVD currentDvd : dvds) {
	        // write the Student object to the file
	        out.println(currentDvd.getTitle() + DELIMITER +
            currentDvd.getReleaseDate() + DELIMITER +
            currentDvd.getMPAArating() + DELIMITER +
            currentDvd.getDirectorsName() + DELIMITER +
            currentDvd.getStudio() + DELIMITER +
            currentDvd.getUserRatingOrNote());
	        // force PrintWriter to write line to the file
	        out.flush();
	    }
	    // Clean up
	    out.close();
	}
	

}
