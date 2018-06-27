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
   
    
    DVD addDVD(String Title, DVD dvd);
    List<DVD>ListDVDS();
    DVD getDVD(String Title);
    DVD removeDVD(String Title);
    
}
