package state;

import service.Inventory;
import service.VendingMachine;

public class MoneyInsertedState implements State {

    @Override
    public void insertMoney(VendingMachine vendingMachine, int amount) {
        vendingMachine.addMoney(amount);
        System.out.println("Money added. Total money now: " + vendingMachine.getMoneyInserted());
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String itemName) {
        // System.out.println("Item selected: " + itemName);
        // vendingMachine.setState(new DispensingState(itemName));
        Inventory inventory = Inventory.getInstance();

        if (!inventory.isAvailable(itemName)) {
            System.out.println("Sorry! Item out of stock");
            vendingMachine.returnChange();
            vendingMachine.setState(new IdleState());
            return;
        }

        int price = inventory.getItem(itemName).getPrice();

        if (vendingMachine.getMoneyInserted() < price) {
            System.out.println(
                    "Not enough money. Please insert " + (price - vendingMachine.getMoneyInserted()) + " more.");
            return;
        }

        vendingMachine.deductMoney(price);
        inventory.deductItemQuantity(itemName);
        vendingMachine.setState(new DispensingState(itemName));
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        System.out.println("Please select an item first");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        int change = vendingMachine.getMoneyInserted();
        vendingMachine.deductMoney(change);
        System.out.println("Returning change: " + change);
        vendingMachine.setState(new IdleState());
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        int refund = vendingMachine.getMoneyInserted();
        vendingMachine.deductMoney(refund);
        System.out.println("Transaction cancelled. Refunding: " + refund);
        vendingMachine.setState(new IdleState());
    }
}
