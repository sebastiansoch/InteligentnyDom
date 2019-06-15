/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inteligentnydom.client.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Button;
import java.util.ArrayList;
import java.util.List;
import org.inteligentnydom.client.HardwareButton;

/**
 *
 * @author ssoch
 */
public class StatusButton extends Button {

    List<Checker> objects;

    public StatusButton(String buttonLabel) {
        super(buttonLabel);
    }

    public void init() {
        this.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                WarningLevel level = WarningLevel.GREEN;
                for (Checker object : objects) {
                    if (object.getWarningLevel() == WarningLevel.RED) {
                        level = WarningLevel.RED;
                        break;
                    } else if (object.getWarningLevel() == WarningLevel.YELLOW) {
                        level = WarningLevel.YELLOW;
                    }
                }
                
                StatusButton.this.setText(level.toString());
            }
        });
    }

    public void add(Checker checker) {
        if (objects == null) {
            objects = new ArrayList<>();
        }
        
        objects.add(checker);
    }

}
