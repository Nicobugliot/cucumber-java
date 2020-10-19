package user;

public class Item {

    private String itemName;
    private Double value;

    public Item(String itemName, Double value) {
        this.itemName = itemName;
        this.value = value;
    }

    public String getItemName() {
        return itemName;
    }

    public Double getValue() {
        return this.value;
    }

}
