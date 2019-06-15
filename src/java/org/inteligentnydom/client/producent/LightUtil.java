/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inteligentnydom.client.producent;

/**
 *
 * @author ssoch
 */
public class LightUtil implements HardwareSwitch {

    private String state = "ON";
    
    @Override
    public boolean switchOn() {
        System.out.println("Light On");
        state = "ON";
        return true;
    }

    @Override
    public boolean switchOff() {
        System.out.println("Light Off");
        state = "OFF";
        return true;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public boolean isSwitchOn() {
        if (state.equals("ON")) {
            return true;
        }
        
        return false;
    }
}
