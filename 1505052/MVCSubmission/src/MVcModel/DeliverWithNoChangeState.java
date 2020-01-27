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
public class DeliverWithNoChangeState implements MachineState{

    VendingMachine vendingmachine;

    public DeliverWithNoChangeState(VendingMachine vendingmachine) {
        this.vendingmachine = vendingmachine;
    }
    
    @Override
    public void DeliverDrink(String itemname) {
        if((vendingmachine.getItemwanted()!=null)){
        vendingmachine.setResult("A "+ itemname+ " with no change is delivered");
        System.out.println("A "+ itemname+ " with no change is delivered");
        vendingmachine.UpdateInventory(itemname, vendingmachine.getAmount(itemname)-1);
        vendingmachine.setMoneyinserted(0);}
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
        System.out.println("Can not give change!");
    }
    
}
