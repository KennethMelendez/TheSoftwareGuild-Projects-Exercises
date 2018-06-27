/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kmlnd
 */
public class DVDDaoImpl implements DVDDao {

    Map<String,DVD> library = new HashMap<>();
    
    @Override
    public DVD addDVD(String Title , DVD dvd) {
        DVD newDVD = library.put(Title, dvd);
        return newDVD;
    }

    @Override
    public List<DVD> ListDVDS() {
        return new ArrayList<DVD>(library.values());
    }

    @Override
    public DVD getDVD(String Title) {
        return library.get(Title);
    }

    @Override
    public DVD removeDVD(String Title) {
        DVD dvds = library.remove(Title);
        return dvds;
    }
    
}
