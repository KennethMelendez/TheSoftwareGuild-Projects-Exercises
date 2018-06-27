/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public class View {

    UserIO io;
    DVD dvd;

    public View(UserIO io, DVD dvd) {
        this.io = io;
        this.dvd = dvd;
    }

    public void menu() {
        io.Display("|=== DVD Library Menu ===|");
        io.Display("1. Add DVD");
        io.Display("2. Remove DVD");
        io.Display("3. Edit DVD info for existing DVD");
        io.Display("4. List All DVDS");
        io.Display("5. Search for a DVD by Title");
        io.Display("6. Exit");
    }

    public void unknownMSG() {
        io.Display("Unknown Command");
    }

    public void GoodBye() {
        io.Display("Good Bye!");
    }

    public int userInput() {
        int result = io.PromptInt("Input Selection");
        return result;
    }

    public DVD getInfo() {
        String Title = io.PromptString("Insert Title");
        
        //String ReleaseDate = io.PromptString("Insert ReleaseDate");
        String ReleaseDate = io.PromptStringTime();                             //added for time might glitch
        String MPAArating = io.PromptString("Insert MPAA rating");
        String DirectorsName = io.PromptString("Insert Director's Name");
        String Studio = io.PromptString("Insert Studio");
        String UserRatingOrNote = io.PromptString("Insert rating or note");
        DVD newDVD = new DVD();
        newDVD.setTitle(Title);
        newDVD.setReleaseDate(ReleaseDate);
        newDVD.setMPAArating(MPAArating);
        newDVD.setDirectorsName(DirectorsName);
        newDVD.setStudio(Studio);
        newDVD.setUserRatingOrNote(UserRatingOrNote);
        return newDVD;
    }

    public void displayInfo(DVD dvds) {
        if (dvds != null) {
            io.Display(dvds.getTitle());
            io.Display(dvds.getReleaseDate());
            io.Display(dvds.getMPAArating());
            io.Display(dvds.getDirectorsName());
            io.Display(dvds.getStudio());
            io.Display(dvds.getUserRatingOrNote());
        } else {
            io.Display("No such DVD");
        }
    }

    public String SuccessBanner() {
        String result = io.PromptString("Action Successful. Hit enter to continue");
        return result;
    }

    public String PromptTitle() {
        String Title = io.PromptString("Insert Title");
        return Title;
    }

    public String PromptEditDVD() {
        String Title = io.PromptString("Insert Title to Edit");
        return Title;
    }

    public void displayDVDSLIST(List<DVD> dvds) {
        for (DVD dvdList : dvds) {
            io.Display(dvdList.getTitle());
            io.Display(dvdList.getReleaseDate());
            io.Display(dvdList.getMPAArating());
            io.Display(dvdList.getDirectorsName());
            io.Display(dvdList.getStudio());
            io.Display(dvdList.getUserRatingOrNote());
        }
    }

}
