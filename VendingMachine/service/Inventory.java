package service;

import java.util.HashMap;
import java.util.Map;

import model.Item;

public class Inventory {

    private static Inventory inventoryInstance = null;
    private Map<String, Item> itemMap = new HashMap<>();

    private Inventory() {
        // Private constructor to prevent external instantiation
    }

    public static Inventory getInstance() {
        if (inventoryInstance == null) {
            inventoryInstance = new Inventory();
        }
        return inventoryInstance;
    }

    public void addItem(Item item) {
        itemMap.put(item.getName(), item);
    }

    public Item getItem(String itemName) {
        return itemMap.get(itemName);
    }

    public void showItems() {
        for (Item item : itemMap.values()) {
            System.out.println(
                    "Item: " + item.getName() + ", Price: " + item.getPrice() + ", Quantity: " + item.getQuantity());
        }
    }

    public boolean isAvailable(String itemName) {
        Item item = itemMap.get(itemName);
        return item != null && item.getQuantity() > 0;
    }

    public void deductItemQuantity(String itemName) {
        Item item = itemMap.get(itemName);
        if (item != null && item.getQuantity() > 0) {
            item.setQuantity(item.getQuantity() - 1);
        }
    }
}
