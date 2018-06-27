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
public class GPSHouse {
    
//the data types were chosen in order to collect information from the user pertaining to the GPS system    
    private String _address;
    private String _city;
    private String _state;
    private String _zipcode;
    private double _longitude;
    private double _latitude;

    public GPSHouse() {
        
    }

    
    
    public String getAddress() {
        return _address;
    }

    public void setAddress(String _address) {
        this._address = _address;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String _city) {
        this._city = _city;
    }

    public String getState() {
        return _state;
    }

    public void setState(String _state) {
        this._state = _state;
    }

    public String getZipcode() {
        return _zipcode;
    }

    public void setZipcode(String _zipcode) {
        this._zipcode = _zipcode;
    }

    public double getLongitude() {
        return _longitude;
    }

    public void setLongitude(double _longitude) {
        this._longitude = _longitude;
    }

    public double getLatitude() {
        return _latitude;
    }

    public void setLatitude(double _latitude) {
        this._latitude = _latitude;
    }
    
}
