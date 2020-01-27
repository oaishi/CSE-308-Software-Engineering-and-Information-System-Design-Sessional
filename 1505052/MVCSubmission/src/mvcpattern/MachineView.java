/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcpattern;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MachineView extends JFrame{

	private JTextField money  = new JTextField(10);
        private JLabel additionLabel = new JLabel("Insert:");
	private JTextField productname = new JTextField(10);
        private JLabel additionLabel1 = new JLabel("Product:(Coca-Cola/Pepsi)");
	private JButton submit = new JButton("Deliver!");
        private JTextField result = new JTextField(30);
	
	MachineView(){
		
		JPanel calcPanel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 200);
		
                calcPanel.add(additionLabel);
		calcPanel.add(money);
		calcPanel.add(additionLabel1);
		calcPanel.add(productname);
		calcPanel.add(submit);
                calcPanel.add(result);
		
		this.add(calcPanel);
		
	}
	
	public float getMoney(){
		
		return Float.parseFloat(money.getText());
		
	}
	
	public String getItem(){
		
		return productname.getText();
		
	}
	
	public void SetResult(String solution){
		
		result.setText(solution);
		
	}
	
	// If the submit is clicked execute a method
	// in the Controller named actionPerformed
	
	void addListener(ActionListener listenForButton){
		
		submit.addActionListener(listenForButton);
	}
	
	// Open a popup that contains the error message passed
	
	void displayErrorMessage(String errorMessage){
		
		JOptionPane.showMessageDialog(this, errorMessage);
		
	}
	
}