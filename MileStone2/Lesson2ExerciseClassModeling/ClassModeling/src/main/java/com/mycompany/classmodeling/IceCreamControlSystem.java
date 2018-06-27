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
public class IceCreamControlSystem {
    //using this as a reference point for ice cream control systems
    //http://www.yogurt-icecreammachine.com/sale-1066189-gravity-feed-low-noisy-soft-serve-ice-cream-machines-new-control-system.html
    
    private int OutPut;
    private String refrigerant;
    private int installedPower;
    private int voltage;

    public int getOutPut() {
        return OutPut;
    }

    public void setOutPut(int OutPut) {
        this.OutPut = OutPut;
    }

    public String getRefrigerant() {
        return refrigerant;
    }

    public void setRefrigerant(String refrigerant) {
        this.refrigerant = refrigerant;
    }

    public int getInstalledPower() {
        return installedPower;
    }

    public void setInstalledPower(int installedPowerl) {
        this.installedPower = installedPowerl;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
    
    
    
}
