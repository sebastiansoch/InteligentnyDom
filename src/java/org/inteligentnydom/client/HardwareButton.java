/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inteligentnydom.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import org.inteligentnydom.client.producent.HardwareSwitch;
import org.inteligentnydom.client.producent.LightUtil;

/**
 *
 * @author ssoch
 */
public class HardwareButton {

    private final String labelBtn;
    private HardwareSwitch hardwareSwitch;
    private Button button;

    public HardwareButton(HardwareSwitch hardwareSwitch, String labelBtn) {
        button = new Button(labelBtn + hardwareSwitch.getState());
        this.hardwareSwitch = hardwareSwitch;
        this.labelBtn = labelBtn;
    }

    public void init() {
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (hardwareSwitch.isSwitchOn()) {
                    hardwareSwitch.switchOff();
                } else {
                    hardwareSwitch.switchOn();
                }

                button.setText(labelBtn + hardwareSwitch.getState());
            }
        });

    }

    public Button getButton() {
        return button;
    }

}
