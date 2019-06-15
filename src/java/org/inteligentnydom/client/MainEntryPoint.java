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
import org.inteligentnydom.client.producent.BlindsUtil;
import org.inteligentnydom.client.producent.DoorUtil;
import org.inteligentnydom.client.producent.LightUtil;
import org.inteligentnydom.client.producent.WindowUtil;
import org.inteligentnydom.client.widget.StatusButton;

/**
 * Main entry point.
 *
 * @author ssoch
 */
public class MainEntryPoint implements EntryPoint {
    private static final String SWIATLO = "Światło ";
    private static final String DRZWI = "Drzwi ";
    private static final String OKNA = "Okna ";
    private static final String ROLETY = "Rolety ";
    
    

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

        LightUtil lightUtil = new LightUtil();
        HardwareButton lightButton = new HardwareButton(lightUtil, SWIATLO);
        lightButton.init();
        
        DoorUtil doorUtil = new DoorUtil();
        HardwareButton doorButton = new HardwareButton(doorUtil, DRZWI);
        doorButton.init();

        WindowUtil windowUtil = new WindowUtil();
        HardwareButton windowButton = new HardwareButton(windowUtil, OKNA);
        windowButton.init();
        
        BlindsUtil blindsUtil = new BlindsUtil();
        HardwareButton blindsButton = new HardwareButton(blindsUtil, ROLETY);
        blindsButton.init();
        
        StatusButton statusButton = new StatusButton("Status");
        statusButton.init();
        statusButton.add(new HardwareButtonChecker(lightUtil, Critical.FALSE));
        statusButton.add(new HardwareButtonChecker(doorUtil, Critical.TRUE));
        statusButton.add(new HardwareButtonChecker(windowUtil, Critical.TRUE));
        statusButton.add(new HardwareButtonChecker(blindsUtil, Critical.FALSE));
        
        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.add(lightButton.getButton());
        verticalPanel.add(doorButton.getButton());
        verticalPanel.add(windowButton.getButton());
        verticalPanel.add(blindsButton.getButton());
        verticalPanel.add(statusButton);
        
        RootPanel.get().add(verticalPanel);
    }
    
    
}
