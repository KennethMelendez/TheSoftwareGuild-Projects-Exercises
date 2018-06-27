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
public class HouseDesignSystem {
 //These data types represent a model of a house   
    private int _floors;
    private int _rooms;
    private int _bathrooms;
    private int _backyard;
    private int _porch;

    public int getFloors() {
        return _floors;
    }

    public void setFloors(int _floors) {
        this._floors = _floors;
    }

    public int getRooms() {
        return _rooms;
    }

    public void setRooms(int _rooms) {
        this._rooms = _rooms;
    }

    public int getBathrooms() {
        return _bathrooms;
    }

    public void setBathrooms(int _bathrooms) {
        this._bathrooms = _bathrooms;
    }

    public int getBackyard() {
        return _backyard;
    }

    public void setBackyard(int _backyard) {
        this._backyard = _backyard;
    }

    public int getPorch() {
        return _porch;
    }

    public void setPorch(int _porch) {
        this._porch = _porch;
    }
    
    
}
