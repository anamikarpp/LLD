import model.Coin;
import model.Item;

public interface VendingMachineService {
    void showItems();

    void acceptMoney(Coin coin);

    int selectItem(String itemName);

    void addItem(Item item);
}
