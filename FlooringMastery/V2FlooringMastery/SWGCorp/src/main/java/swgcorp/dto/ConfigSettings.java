/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.dto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import swgcorp.dao.PersistenceException;

/**
 *
 * @author kmlnd
 */
public class ConfigSettings {

    public static final String MODE_FILE = "config.txt";
    public static final String TRAININGMODE = "Training Mode";
    public static final String NORMALMODE = "Production Mode";

    public boolean isTrainingModeActive() throws PersistenceException {
        
        Scanner scanner;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(MODE_FILE)));
        } catch (FileNotFoundException e) {
            throw new PersistenceException("File not found", e);
        }
        
        

        String currentLine = "";
        //while (scanner.hasNextLine()) {
        try {
            currentLine = scanner.nextLine();
        } catch (Exception e) {
            throw new PersistenceException("Error reading mode file", e);
        }

        //}
        if (currentLine.equalsIgnoreCase(TRAININGMODE)) {
            return true;
        } else if (currentLine.equalsIgnoreCase(NORMALMODE)) {
            return false;
        } else {
            return false;
        }
    }
}
