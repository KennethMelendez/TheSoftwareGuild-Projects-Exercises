/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classmodeling;

/**
 *
 * @author kmlnd
 */
public class AirplaneAirTraffic {

//these data types represent information for the air traffic control system 
    
    private boolean _arrival;
    private boolean _departure;
    private boolean _traficDelays;
    private int _lengthOfDelays;
    private boolean _closedAirport;

    public boolean isArrival() {
        return _arrival;
    }

    public void setArrival(boolean _arrival) {
        this._arrival = _arrival;
    }

    public boolean isDeparture() {
        return _departure;
    }

    public void setDeparture(boolean _departure) {
        this._departure = _departure;
    }

    public boolean isTraficDelays() {
        return _traficDelays;
    }

    public void setTraficDelays(boolean _traficDelays) {
        this._traficDelays = _traficDelays;
    }

    public int getLengthOfDelays() {
        return _lengthOfDelays;
    }

    public void setLengthOfDelays(int _lengthOfDelays) {
        this._lengthOfDelays = _lengthOfDelays;
    }

    public boolean isClosedAirport() {
        return _closedAirport;
    }

    public void setClosedAirport(boolean _closedAirport) {
        this._closedAirport = _closedAirport;
    }
    
    
}
