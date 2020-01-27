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
public class InsufficientCurrencyState implements MachineState{
    
    VendingMachine vendingmachine;

    public InsufficientCurrencyState(VendingMachine vendingmachine) {
        this.vendingmachine = vendingmachine;
    }

    @Override
    public void DeliverDrink(String itemname) {
        vendingmachine.setResult("Please enter sufficient amount!");
        System.out.println("Please enter sufficient amount!");
    }

    @Override
    public void InsertMoney(float amount) {
        vendingmachine.setCurrentstate(vendingmachine.getIdlestate());
        vendingmachine.InsertMoney(amount);
    }

    @Override
    public void EjectChange(float amount) {
        if(vendingmachine.getMoneyinserted()!=0){
        vendingmachine.setResult("Please enter sufficient amount!\n$ "+String.valueOf(amount)+ " ejected.");
        System.out.println("Please enter sufficient amount!\n$ "+String.valueOf(amount)+ " ejected.");}
        vendingmachine.setMoneyinserted(0);
    }
    
}
