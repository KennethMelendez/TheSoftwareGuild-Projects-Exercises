/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public interface DVDDao {
   
    
    DVD addDVD(String Title, DVD dvd) throws DVDLibraryDaoException;
    List<DVD>ListDVDS() throws DVDLibraryDaoException;
    DVD getDVD(String Title) throws DVDLibraryDaoException;
    DVD removeDVD(String Title) throws DVDLibraryDaoException;
    
}
