/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inteligentnydom.client;

import org.inteligentnydom.client.producent.HardwareSwitch;
import org.inteligentnydom.client.producent.LightUtil;
import org.inteligentnydom.client.widget.Checker;
import org.inteligentnydom.client.widget.WarningLevel;

/**
 *
 * @author ssoch
 */
public class HardwareButtonChecker implements Checker {

    private HardwareSwitch hardware;
    private Critical critical;

    HardwareButtonChecker(HardwareSwitch hardware, Critical critical) {
        this.hardware = hardware;
        this.critical = critical;
    }

    @Override
    public WarningLevel getWarningLevel() {
        if (hardware.isSwitchOn() && critical == Critical.TRUE) {
            return WarningLevel.RED;
        } 
        
        if (hardware.isSwitchOn() && critical == Critical.FALSE) {
            return WarningLevel.YELLOW;
        }
        
        return WarningLevel.GREEN;
    }
    
    
    
}
