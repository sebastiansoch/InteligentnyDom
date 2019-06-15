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
public class DoorUtil implements HardwareSwitch {

    private String state = "OPEN";

    private boolean doorOpen() {
        System.out.println("Door Open");
        state = "OPEN";
        return true;
    }

    private boolean doorClose() {
        System.out.println("Door Close");
        state = "CLOSE";
        return true;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public boolean switchOff() {
        return doorClose();
    }

    @Override
    public boolean switchOn() {
        return doorOpen();
    }

    @Override
    public boolean isSwitchOn() {
        if (state.equals("OPEN")) {
            return true;
        }

        return false;
    }
}
