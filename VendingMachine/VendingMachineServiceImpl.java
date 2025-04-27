import java.util.ArrayList;
import java.util.List;

import model.Coin;
import model.Item;

public class VendingMachineServiceImpl implements VendingMachineService {

    private List<Item> itemList = new ArrayList<>();
    private int moneyInserted = 0;

    @Override
    public void showItems() {
        for (Item item : itemList) {
            System.out.println("Name: " + item.getName());
            System.out.println("Price: " + item.getPrice());
        }
    }

    @Override
    public void acceptMoney(Coin coin) {
        moneyInserted += coin.getValue();
        System.out.println("Money inserted: " + moneyInserted);
    }

    @Override
    public void addItem(Item item) {
        itemList.add(item);
    }

    private void returnChangeInCoins(int change) {
        if (change == 0) {
            System.out.println("No change to return.");
            return;
        }
        System.out.println("Returning change:");

        Coin[] coins = Coin.values();
        java.util.Arrays.sort(coins, (a, b) -> b.getValue() - a.getValue());

        for (Coin coin : coins) {
            while (change >= coin.getValue()) {
                System.out.println("Returning coin: " + coin.getValue());
                change -= coin.getValue();
            }
        }
    }

    @Override
    public int selectItem(String itemName) {
        int change = 0;
        boolean itemFound = false;
        for (Item item : itemList) {
            if (item.getName().equals(itemName)) {
                itemFound = true;
                int price = item.getPrice();
                if (moneyInserted >= price && item.getQuantity() > 0) {
                    item.setQuantity(item.getQuantity() - 1);
                    change = moneyInserted - price;
                    System.out.println("Please take your: " + itemName);
                    returnChangeInCoins(change);
                    moneyInserted = 0;
                } else if (item.getQuantity() == 0) {
                    System.out.println("Sorry, item is out of stock!");
                } else {
                    System.out.println("More amount required: " + (price - moneyInserted));
                }
                break;
            }
        }
        if (!itemFound) {
            System.out.println(itemName + " not found");
        }
        return change;
    }

}
