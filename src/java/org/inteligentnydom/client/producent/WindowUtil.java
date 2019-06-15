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
public class WindowUtil implements HardwareSwitch {

    private String state = "OPEN";

    private boolean windowOpen() {
        System.out.println("Window Open");
        state = "OPEN";
        return true;
    }

    private boolean windowClose() {
        System.out.println("Window Close");
        state = "CLOSE";
        return true;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public boolean switchOff() {
        return windowClose();
    }

    @Override
    public boolean switchOn() {
        return windowOpen();
    }

    @Override
    public boolean isSwitchOn() {
        if (state.equals("OPEN")) {
            return true;
        }

        return false;
    }
}
