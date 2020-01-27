package mvcpattern;

import MVcModel.VendingMachine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MVCController {
	
	private MachineView theView;
	private VendingMachine theModel;
	
	public MVCController(MachineView theView, VendingMachine theModel) {
		this.theView = theView;
		this.theModel = theModel;
		this.theView.addListener(new Listener());
	}
	
	class Listener implements ActionListener{

                @Override
		public void actionPerformed(ActionEvent e) {
			
			float firstNumber;
                        String secondNumber;
			try{
                            
                            firstNumber = theView.getMoney();
                            secondNumber = theView.getItem();
                            theModel.InsertMoney(firstNumber);
                            theModel.DeliverDrink(secondNumber);
                            theView.SetResult(theModel.getResult());
			
			}

			catch(NumberFormatException ex){	
				System.out.println(ex);
				theView.displayErrorMessage("Invalid Input");
			}
			
		}
		
	}
	
}