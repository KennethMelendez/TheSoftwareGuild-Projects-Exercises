/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.Controller;
import com.sg.dvdlibrary.dao.DVDDao;
import com.sg.dvdlibrary.dao.DVDDaoImpl;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOImpl;
import com.sg.dvdlibrary.ui.View;

/**
 *
 * @author kmlnd
 */
public class App {
    
    //1.) Remaking DVD Library as Practice.
    //2.) Also Modifying the DVD Library application so that the release date of each movie is represented as a LocalDate.
    //3.) Experimenting with Dependency Injection
    
    
    
    public static void main(String[] args) {
    UserIO io = new UserIOImpl();
    DVD dvd = new DVD();
    View view = new View(io,dvd);
    DVDDao dao = new DVDDaoImpl();
    Controller c = new Controller(view,dao);
    c.run();
    
    }
}
