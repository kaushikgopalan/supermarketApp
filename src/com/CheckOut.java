package com;

import com.models.*;

import java.util.ArrayList;

/**
 * Created by kaushik on 12-Feb-17.
 */
public class CheckOut {

    /*
    you need to maintain a list somewhere to which you will add items to it.

     */
    ArrayList<PricingRule> pricingRules;
    Bill bill;
    ArrayList<SpecialPriceItem> specialPriceItems;

    public CheckOut(ArrayList<PricingRule> pr) {
        this.pricingRules = pr;
        bill = new Bill();// initializing it locally for now.
        this.specialPriceItems = ListProviders.getSpecialPriceItemsByPricingRules(this.pricingRules);
    }

    public void scan(String itemId) {
        Item item;
        final boolean[] scanned = {false};
        if (ListProviders.getMapIdToItems().containsKey(itemId))
            item = ListProviders.getMapIdToItems().get(itemId);
        else {
            return;
        }
        pricingRules.forEach(pr -> {
            if (pr.getItem() == item) {
                if (bill.getBillingItems().containsKey(item)) {
                    /*
                        there is a bill entry for the item and scanning another item now
                        gives us a quantity that qualifies for a specialPriceItem for it.
                     */
                    if ((bill.getBillingItems().get(item) + 1) == pr.getQuantity()) {
                        for (SpecialPriceItem spi : specialPriceItems) {
                            /*
                            enter a bill entry for a Special price item, if its already in the bill.
                            if its not, add a new value of special Price Item.
                            break when we have found and added the billing item
                             */

                            if (bill.getBillingItems().containsKey(spi) && spi.getBasicItemId()==item.getItemId()) {

                                if(spi.getBasicItemId()==item.getItemId()){
                                bill.getBillingItems().remove(item);
                                bill.getBillingItems().put(spi, bill.getBillingItems().get(spi) + 1);
                                scanned[0] = true;
                                return;

                                }
                                else{
                                }

                            } else if(spi.getBasicItemId()==item.getItemId()) {
                                bill.getBillingItems().remove(item);// remove it as adding spi
                                bill.getBillingItems().put(spi, 1);
                                scanned[0] = true;
                                return;
                            }
                        }
                    } else {
                        bill.getBillingItems().put(item, bill.getBillingItems().get(item) + 1);
                        scanned[0] = true;
                        return;
                    }
                } else {
                    bill.getBillingItems().put(item, 1);
                    scanned[0] = true;
                    return;
                }
            }

        });
        if (bill.getBillingItems().containsKey(item) && !scanned[0]) {
            bill.getBillingItems().put(item, bill.getBillingItems().get(item) + 1);
            scanned[0] = true;
            return;
        }
        if (!scanned[0]){

            bill.getBillingItems().put(item, 1);
        }

    }

    public double total() {

        double sum = 0;
        if (bill != null) {
            for (AbstractItem ai : bill.getBillingItems().keySet()) {
                sum += ai.getRate() * bill.getBillingItems().get(ai);
            }

        }
        return sum;
    }
}
