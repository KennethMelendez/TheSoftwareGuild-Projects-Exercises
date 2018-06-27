/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDDao;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.View;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public class Controller {

    View v;
    DVDDao dao;

    public Controller(View v, DVDDao dao) {
        this.v = v;
        this.dao = dao;
    }

    public void run() {
        boolean refresh = true;

        while (refresh == true) {
            v.menu();
            int menuSelect = UserIO();
            switch (menuSelect) {
                case 1:
                    //add dvd
                    AddDVD();
                    break;
                case 2:
                    //remove dvd
                    DeleteDVD();
                    break;
                case 3:
                    //edit dvd
                    EditDVD();
                    break;
                case 4:
                    //List all dvds
                    ListDVDS();
                    break;
                case 5:
                    //search dvd by title
                    getADvd();
                    break;
                case 6:
                    //exit
                    refresh = false;
                    break;
                default:
                    UnknownMsg();

            }
        }
        ExitMsg();
    }

    private void AddDVD(){
        DVD dvd = v.getInfo();
        dao.addDVD(dvd.getTitle(), dvd);
        v.SuccessBanner();
    }
    private void DeleteDVD(){
        String Title = v.PromptTitle();
        dao.removeDVD(Title);
        v.SuccessBanner();
    }
    private void EditDVD(){
        String Title = v.PromptEditDVD();
        dao.removeDVD(Title);
        DVD dvd = v.getInfo();
        dao.addDVD(dvd.getTitle(), dvd);
        v.SuccessBanner();
    }
    private void ListDVDS(){
        List<DVD> dvds = dao.ListDVDS();
        v.displayDVDSLIST(dvds);
        v.SuccessBanner();
    }
    private void getADvd(){
        String Title = v.PromptTitle();
        DVD dvd = dao.getDVD(Title);
        v.displayInfo(dvd);
        v.SuccessBanner();
    }
    
    private void ExitMsg() {
        v.GoodBye();
    }

    private void UnknownMsg() {
        v.unknownMSG();
    }

    private int UserIO() {
        return v.userInput();
    }
}
