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
public class CarInventorySystem {
    private String vehicleName;
    private String VehicleDescription;
    private int Costs;
    private String brand;

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleDescription() {
        return VehicleDescription;
    }

    public void setVehicleDescription(String VehicleDescription) {
        this.VehicleDescription = VehicleDescription;
    }

    public int getCosts() {
        return Costs;
    }

    public void setCosts(int Costs) {
        this.Costs = Costs;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    
}
