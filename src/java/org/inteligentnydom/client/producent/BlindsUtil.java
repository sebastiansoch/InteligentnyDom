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
public class BlindsUtil implements HardwareSwitch {

    private String state = "UP";

    private boolean blindsUp() {
        System.out.println("Blinds Up");
        state = "UP";
        return true;
    }

    private boolean blindsDown() {
        System.out.println("Blinds Down");
        state = "DOWN";
        return true;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public boolean switchOff() {
        return blindsDown();
    }

    @Override
    public boolean switchOn() {
        return blindsUp();
    }

    @Override
    public boolean isSwitchOn() {
        if (state.equals("UP")) {
            return true;
        }

        return false;
    }
}
