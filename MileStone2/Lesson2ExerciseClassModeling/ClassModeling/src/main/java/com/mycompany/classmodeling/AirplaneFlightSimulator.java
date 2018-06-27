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
public class AirplaneFlightSimulator {
//creating these data types in order to implement a flight simulator;    
    private boolean _ReadyForTakeOff;
    private int _longitude;
    private int _latitude;
    private boolean _primaryFlightControlsReady;
    private boolean _secondaryFlightContsolsReady;

    public boolean isReadyForTakeOff() {
        return _ReadyForTakeOff;
    }

    public void setReadyForTakeOff(boolean _ReadyForTakeOff) {
        this._ReadyForTakeOff = _ReadyForTakeOff;
    }

    public int getLongitude() {
        return _longitude;
    }

    public void setLongitude(int _longitude) {
        this._longitude = _longitude;
    }

    public int getLatitude() {
        return _latitude;
    }

    public void setLatitude(int _latitude) {
        this._latitude = _latitude;
    }

    public boolean isPrimaryFlightControlsReady() {
        return _primaryFlightControlsReady;
    }

    public void setPrimaryFlightControlsReady(boolean _primaryFlightControlsReady) {
        this._primaryFlightControlsReady = _primaryFlightControlsReady;
    }

    public boolean isSecondaryFlightContsolsReady() {
        return _secondaryFlightContsolsReady;
    }

    public void setSecondaryFlightContsolsReady(boolean _secondaryFlightContsolsReady) {
        this._secondaryFlightContsolsReady = _secondaryFlightContsolsReady;
    }
    
    
}
