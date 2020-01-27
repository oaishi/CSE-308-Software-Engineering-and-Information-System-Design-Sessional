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
public interface MachineState {
    void DeliverDrink(String itemname);
    void InsertMoney(float amount);
    void EjectChange(float amount);
    
}
