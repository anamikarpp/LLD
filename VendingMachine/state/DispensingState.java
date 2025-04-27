package state;

import model.Item;
import service.Inventory;
import service.VendingMachine;

public class DispensingState implements State {

    private String itemName;

    public DispensingState(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, int amount) {
        System.out.println("Currently dispensing item. Cannot insert money now.");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String itemName) {
        System.out.println("Already dispensing an item. Please wait");
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        // Inventory inventory = Inventory.getInstance();
        // Item item = inventory.getItem(itemName);

        // if (item == null) {
        // System.out.println("Item not found!");
        // vendingMachine.returnChange();
        // vendingMachine.setState(new IdleState());
        // return;
        // }

        // if (item.getQuantity() <= 0) {
        // System.out.println("Item out of stock!");
        // vendingMachine.returnChange();
        // vendingMachine.setState(new IdleState());
        // return;
        // }

        // if (vendingMachine.getMoneyInserted() >= item.getPrice()) {
        // item.setQuantity(item.getQuantity() - 1);
        // vendingMachine.deductMoney(item.getPrice());
        // System.out.println("Dispensing: " + itemName);

        // vendingMachine.returnChange();

        // vendingMachine.setState(new IdleState());
        // } else {
        // System.out.println("Insufficient money! Please insert more.");
        // vendingMachine.setState(new MoneyInsertedState());
        // }
        System.out.println("Dispensing: " + itemName);
        vendingMachine.returnChange();
        vendingMachine.setState(new IdleState());
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        System.out.println("Please complete dispensing first");
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        System.out.println("Cannot cancel now, item is being dispensed.");
    }
}
