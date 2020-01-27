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
public class DeliverWithChangeState implements MachineState{

    VendingMachine vendingmachine;

    public DeliverWithChangeState(VendingMachine vendingmachine) {
        this.vendingmachine = vendingmachine;
    } 

    @Override
    public void DeliverDrink(String itemname) {
        if(vendingmachine.getItemwanted()!=null){
        System.out.println("A "+ itemname+ " with change is delivered");
        vendingmachine.UpdateInventory(itemname, vendingmachine.getAmount(itemname)-1);
        float change = vendingmachine.getMoneyinserted()-vendingmachine.getPrice(itemname);
        vendingmachine.setResult("A "+ itemname+ " with change"+Float.toString(change)+" is delivered");
        EjectChange(change);}
        else{vendingmachine.setResult("Insert money first!");
            System.out.println("Insert money first!");}
        vendingmachine.setItemwanted(null);
    }

    @Override
    public void InsertMoney(float amount) {
        vendingmachine.setCurrentstate(vendingmachine.getIdlestate());
        vendingmachine.InsertMoney(amount);
    }

    @Override
    public void EjectChange(float amount) {
        if(vendingmachine.getMoneyinserted()!=0)
        System.out.println("$ " + String.valueOf(amount)+ " ejected.");
        vendingmachine.setMoneyinserted(0);
    }
    
}
