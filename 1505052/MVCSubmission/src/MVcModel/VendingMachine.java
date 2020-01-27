/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVcModel;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Faria huq
 */
public class VendingMachine{
    MachineState deliverwithchangestate;
    MachineState deliverwithnochangestate;
    MachineState idlestate;
    MachineState insufficientcurrencystate;       
    MachineState inventorydepletionstate;
    MachineState currentstate;
    
    //float cashinmachine;
    float moneyinserted = 0;
    String itemwanted = null;
    String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    Map<String, Float> price = new HashMap<String, Float>();
    Map<String, Integer> inventory = new HashMap<String, Integer>();
    
    public VendingMachine() {
        
        this.deliverwithchangestate = new DeliverWithChangeState(this);
        this.deliverwithnochangestate = new DeliverWithNoChangeState(this);
        this.idlestate = new IdleState(this);
        this.insufficientcurrencystate = new InsufficientCurrencyState(this);
        this.inventorydepletionstate = new InventoryDepletionState(this);
        
        this.currentstate = this.idlestate;
        
        //this.cashinmachine = (float) 20.00;
        
        price.put("Coca-Cola", new Float(25.00));
        price.put("Pepsi", new Float(15.00));
        
        inventory.put("Coca-Cola", new Integer(10));
        inventory.put("Pepsi", new Integer(14));
    }
    
    public float getPrice(String item){
        Float f = price.get(item);
        return (f != null ? f : 0);
    }
    
    public int getAmount(String item){
        Integer f = inventory.get(item);
        return (f != null ? f : Integer.MIN_VALUE);
    }

    /*public float getCashinmachine() {
        return cashinmachine;
    }

    public void setCashinmachine(float cashinmachine) {
        this.cashinmachine = cashinmachine;
    }*/

    public float getMoneyinserted() {
        return moneyinserted;
    }

    public void setMoneyinserted(float moneyinserted) {
        this.moneyinserted = moneyinserted;
    }

    public String getItemwanted() {
        return itemwanted;
    }

    public void setItemwanted(String itemwanted) {
        this.itemwanted = itemwanted;
    }

    public void setCurrentstate(MachineState currentstate) {
        this.currentstate = currentstate;
    }
    
    public void UpdatePrice(String name , float amount){
        price.replace(name, amount);
    }
    
    public void UpdateInventory(String name , int amount){
        inventory.replace(name, amount);
    }

    public void DeliverDrink(String itemname) {
        currentstate.DeliverDrink(itemname);
    }

    public void InsertMoney(float amount) {
        currentstate.InsertMoney(amount);
    }

    public void EjectChange(float amount) {
        currentstate.EjectChange(amount);
    }

    public MachineState getDeliverwithchangestate() {
        return deliverwithchangestate;
    }

    public MachineState getDeliverwithnochangestate() {
        return deliverwithnochangestate;
    }

    public MachineState getIdlestate() {
        return idlestate;
    }

    public MachineState getInsufficientcurrencystate() {
        return insufficientcurrencystate;
    }

    public MachineState getInventorydepletionstate() {
        return inventorydepletionstate;
    }       
            
}
