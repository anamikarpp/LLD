import model.Item;
import service.Inventory;
import service.VendingMachine;

public class Main {
    public static void main(String[] args) {
        // VendingMachineService vendingMachine = new VendingMachineServiceImpl();
        // vendingMachine.addItem(new Item(1, "chips", 40, 5));
        // vendingMachine.addItem(new Item(2, "Brownie", 100, 10));
        // vendingMachine.showItems();
        // vendingMachine.acceptMoney(Coin.HUNDRED);
        // vendingMachine.selectItem("chips");
        // vendingMachine.acceptMoney(Coin.FIFTY);

        // Setup inventory
        Inventory inventory = Inventory.getInstance();
        inventory.addItem(new Item(1, "chips", 40, 5));
        inventory.addItem(new Item(2, "Brownie", 100, 2));
        inventory.addItem(new Item(3, "Soda", 60, 3));

        // show available items
        inventory.showItems();

        VendingMachine vendingMachine = new VendingMachine();

        // Flow 1 Insert money and select item
        System.out.println("\nCustomer 1:");
        vendingMachine.insertMoney(50);
        vendingMachine.selectItem("Chips");
        vendingMachine.dispenseItem();

        // Flow 2: Insert insufficient money
        System.out.println("\nCustomer 2:");
        vendingMachine.insertMoney(30);
        vendingMachine.selectItem("Soda");

        // Insert more money
        vendingMachine.insertMoney(40);
        vendingMachine.selectItem("Soda");
        vendingMachine.dispenseItem();

        // cancel transaction
        System.out.println("\nCustomer 3:");
        vendingMachine.insertMoney(100);
        vendingMachine.cancel();

    }

}
