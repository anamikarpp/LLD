package state;

import service.VendingMachine;

public interface State {
    void insertMoney(VendingMachine vendingMachine, int amount);

    void selectItem(VendingMachine vendingMachine, String itemName);

    void dispenseItem(VendingMachine vendingMachine);

    void returnChange(VendingMachine vendingMachine);

    void cancel(VendingMachine vendingMachine);
}
