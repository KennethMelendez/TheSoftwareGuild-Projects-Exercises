/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.statecapitals2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author kmlnd
 */
public class Capital {
    
    private String name;
    private int population;
    private int SquareMileage;
   
    public String getName() {
        return name + " - ";
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getSquareMileage() {
        return SquareMileage;
    }

    public void setSquareMileage(int SquareMileage) {
        this.SquareMileage = SquareMileage;
    }
    
    
    

    
}
