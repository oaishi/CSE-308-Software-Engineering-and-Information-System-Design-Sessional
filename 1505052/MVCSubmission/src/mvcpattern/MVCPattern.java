/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcpattern;

import MVcModel.VendingMachine;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Faria huq
 */
public class MVCPattern  {
    
    //here I tried to reinvent the State assignment using MVC pattern . 
    //The controller class control communication between the view and model class
    
  public static void main(String[] args) {
    	
    	MachineView theView = new MachineView();
        
    	VendingMachine theModel = new VendingMachine();
        
        MVCController theController = new MVCController(theView,theModel);
        
        theView.setVisible(true);
        
    }
}
