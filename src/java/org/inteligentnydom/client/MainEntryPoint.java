/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inteligentnydom.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.inteligentnydom.client.producent.DoorUtil;
import org.inteligentnydom.client.producent.LightUtil;

/**
 * Main entry point.
 *
 * @author ssoch
 */
public class MainEntryPoint implements EntryPoint {
    private static final String DRZWI = "Drzwi ";
    private static final String SWIATLO = "Światło ";

    /**
     * Creates a new instance of MainEntryPoint
     */
    public MainEntryPoint() {
    }

    /**
     * The entry point method, called automatically by loading a module that
     * declares an implementing class as an entry-point
     */
    public void onModuleLoad() {

        
        String[] lightAction = new String[]{"ON"};        
        final Button lightBtn = new Button(SWIATLO + lightAction[0]);
        LightUtil lightUtil = new LightUtil();
        lightBtn.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (lightAction[0].equals("ON")) {
                    lightUtil.switchOff();
                    lightAction[0] = "OFF";
                } else {
                    lightUtil.switchOn();
                    lightAction[0] = "ON";
                }
                
                lightBtn.setText(SWIATLO + lightAction[0]);
            }
        });
        

        String[] doorAction = new String[]{"OPEN"};
        final Button doorBtn = new Button(DRZWI + doorAction[0]);
        DoorUtil doorUtil = new DoorUtil();
        doorBtn.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (doorAction[0].equals("OPEN")) {
                    doorUtil.doorClose();
                    doorAction[0] = "CLOSE";
                } else {
                    doorUtil.doorOpen();
                    doorAction[0] = "OPEN";
                }
                
                doorBtn.setText(DRZWI + doorAction[0]);
            }
        });
        
        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.add(lightBtn);
        verticalPanel.add(doorBtn);
        RootPanel.get().add(verticalPanel);
    }
}
