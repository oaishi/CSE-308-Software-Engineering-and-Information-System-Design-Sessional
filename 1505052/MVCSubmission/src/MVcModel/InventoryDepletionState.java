/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVcModel;

/**
 *
 * @author Faria huq
 */
public class InventoryDepletionState implements MachineState{
    
    VendingMachine vendingmachine;

    public InventoryDepletionState(VendingMachine vendingmachine) {
        this.vendingmachine = vendingmachine;
    }
    
    @Override
    public void DeliverDrink(String itemname) {
        System.out.println("Product "+itemname+" is out of Stock!");
        vendingmachine.setResult("Product "+itemname+" is out of Stock!"+String.valueOf(vendingmachine.getMoneyinserted())+ " ejected.");
        EjectChange(vendingmachine.getMoneyinserted());
    }

    @Override
    public void InsertMoney(float amount) {
        vendingmachine.setCurrentstate(vendingmachine.getIdlestate());
        vendingmachine.InsertMoney(amount);
    }

    @Override
    public void EjectChange(float amount) {
        if(vendingmachine.getMoneyinserted()!=0)
        System.out.println("$ "+String.valueOf(amount)+ " ejected.");
        vendingmachine.setMoneyinserted(0);
    }
    
}
