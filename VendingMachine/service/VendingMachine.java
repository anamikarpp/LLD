
// import java.util.ArrayList;
// import java.util.List;

// public class VendingMachine {

// private List<Item> itemList = new ArrayList<>();
// private int moneyInserted = 0;

// public void showItems() {
// for (Item item : itemList) {
// System.out.println("Name: " + item.getName());
// System.out.println("Price: " + item.getPrice());
// }
// }

// public void acceptMoney(int money) {
// moneyInserted += money;
// System.out.println("Money inserted: " + moneyInserted);
// }

// public void addItem(Item item) {
// itemList.add(item);
// }

// int selectItem(String itemName) {
// int change = 0;
// boolean itemFound = false;
// for (Item item : itemList) {
// if (item.getName().equals(itemName)) {
// itemFound = true;
// int price = item.getPrice();
// if (moneyInserted >= price && item.getQuantity() > 0) {
// item.setQuantity(item.getQuantity() - 1);
// change = moneyInserted - price;
// System.out.println("Please take your: " + itemName);
// System.out.println("Change returned: " + change);
// moneyInserted = 0;
// } else if (item.getQuantity() == 0) {
// System.out.println("Sorry, item is out of stock!");
// } else {
// System.out.println("More amount required: " + (price - moneyInserted));
// }
// break;
// }
// }
// if (!itemFound) {
// System.out.println(itemName + " not found");
// }
// return change;
// }
// }
package service;

import state.State;
import state.IdleState;

public class VendingMachine {

    private State state;
    private int moneyInserted;

    public VendingMachine() {
        this.state = new IdleState();
        this.moneyInserted = 0;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void addMoney(int amount) {
        this.moneyInserted += amount;
    }

    public int getMoneyInserted() {
        return moneyInserted;
    }

    public void deductMoney(int amount) {
        this.moneyInserted -= amount;
    }

    public void insertMoney(int amount) {
        state.insertMoney(this, amount);
    }

    public void selectItem(String itemName) {
        state.selectItem(this, itemName);
    }

    public void dispenseItem() {
        state.dispenseItem(this);
    }

    public void returnChange() {
        state.returnChange(this);
    }

    public void cancel() {
        state.cancel(this);
    }
}
