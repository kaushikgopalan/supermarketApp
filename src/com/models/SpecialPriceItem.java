package com.models;

/**
 * Created by kaushik on 16-Feb-17.
 */
public class SpecialPriceItem extends AbstractItem {

    int quantity;
    String basicItemId;
    /*
    this constructor creates  a com.models.SpecialPriceItem from a standard item.
    what we get is a specialPriceItem object that replaces quantity number of
    com.models.Item objects and sets a new rate as well.
     */
    public SpecialPriceItem(Item i, int quantity, double rate) {
        this.quantity = quantity;
        this.rate = rate;
        this.name = i.getName();
        this.itemId = "S_" + i.getItemId();
        this.basicItemId=i.getItemId();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBasicItemId() {
        return basicItemId;
    }

    public void setBasicItemId(String basicItemId) {
        this.basicItemId = basicItemId;
    }
}
