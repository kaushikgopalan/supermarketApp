package com.models;

/**
 * Created by kaushik on 13-Feb-17.
 */
public class AbstractItem {
    Double rate;
    String name;
    String itemId;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String toString(){
            return this.getName()+" "+this.getItemId()+" "+this.getRate();
    }
}
