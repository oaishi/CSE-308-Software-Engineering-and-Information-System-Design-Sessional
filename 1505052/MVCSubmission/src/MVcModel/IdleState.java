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
public class IdleState implements MachineState{

    VendingMachine vendingmachine;

    public IdleState(VendingMachine vendingmachine) {
        this.vendingmachine = vendingmachine;
    }
    
    @Override
    public void DeliverDrink(String itemname) {
        if(vendingmachine.getMoneyinserted()==0){
            vendingmachine.setResult("Insert money first!");
            System.out.println("Insert money first!");}
        else{
            int i = vendingmachine.getAmount(itemname);
            if(i==Integer.MIN_VALUE){vendingmachine.setResult("We don't have this item!");
                System.out.println("We don't have this item!");}
            else if(i==0){
                vendingmachine.setCurrentstate(vendingmachine.getInventorydepletionstate());
                vendingmachine.DeliverDrink(itemname);
            }
            else{
                float price = vendingmachine.getPrice(itemname);
                vendingmachine.setItemwanted(itemname);
                if(price == vendingmachine.getMoneyinserted()){
                    vendingmachine.setCurrentstate(vendingmachine.getDeliverwithnochangestate());
                    vendingmachine.DeliverDrink(itemname);
                }
                else if(price > vendingmachine.getMoneyinserted()){
                    vendingmachine.setCurrentstate(vendingmachine.getInsufficientcurrencystate());
                    vendingmachine.EjectChange(vendingmachine.getMoneyinserted());
                }
                else{
                    vendingmachine.setCurrentstate(vendingmachine.getDeliverwithchangestate());
                    vendingmachine.DeliverDrink(itemname);
                }
            }
        }
    }

    @Override
    public void InsertMoney(float amount) {
        if(vendingmachine.getMoneyinserted()==0)
        vendingmachine.setMoneyinserted(amount);
        else{vendingmachine.setResult("Wait until current transaction");
            System.out.println("Wait until current transaction");}
    }

    @Override
    public void EjectChange(float amount) {
        vendingmachine.setResult("Can not give change!");
        System.out.println("Can not give change!");
    }
    
}
