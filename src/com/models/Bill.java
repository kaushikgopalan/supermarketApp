package com.models;

import java.util.HashMap;

/**
 * Created by kaushik on 16-Feb-17.
 */
public class Bill {

    HashMap<AbstractItem, Integer> billingItems;

    public HashMap<AbstractItem, Integer> getBillingItems() {
        return billingItems;
    }

    public void setBillingItems(HashMap<AbstractItem, Integer> billingItems) {
        this.billingItems = billingItems;
    }

    public Bill(){
        this.billingItems=new HashMap<>();
    }


}
