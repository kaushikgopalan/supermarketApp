package com.models;

/**
 * Created by kaushik on 11-Feb-17.
 */
public class PricingRule {
    Item item;
    int quantity;
    double price;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PricingRule(Item item, int quantity, double price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;

    }

    public String toString(){
        return this.getItem()+" "+this.getPrice()+" "+this.getQuantity();
    }



}
