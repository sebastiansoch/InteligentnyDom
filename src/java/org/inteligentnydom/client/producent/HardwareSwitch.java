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
public interface HardwareSwitch {

    String getState();

    boolean switchOff();

    boolean switchOn();

    boolean isSwitchOn();
    
}
