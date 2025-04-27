
package state;

import service.VendingMachine;

public class IdleState implements State {

    @Override
    public void insertMoney(VendingMachine vendingMachine, int amount) {
        vendingMachine.addMoney(amount);
        System.out.println("Money inserted: " + amount);
        vendingMachine.setState(new MoneyInsertedState());
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String itemName) {
        System.out.println("Please insert money first");
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        System.out.println("Insert money and select item first!");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        System.out.println("No money to return!");
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        System.out.println("Nothing to cancel.");
    }
}
