package com;

import com.models.AbstractItem;
import com.models.Item;
import com.models.PricingRule;
import com.models.SpecialPriceItem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kaushik on 16-Feb-17.
 */
public class ListProviders {

    /*
    currently using this as a way to get dummy data.
    in actual implementation, we would have a db/service layer to get
    a list of all Items.
     */
    private static ArrayList<Item> itemsList;
    private static HashMap<String, Item> mapIdToItems;
    private static ArrayList<SpecialPriceItem> specialPriceItems;

    public static ArrayList<Item> getItemsList() {
        if (itemsList == null) {
            itemsList = new ArrayList<Item>();

            itemsList.add(new Item("A", (double) 40, "A"));
            itemsList.add(new Item("B", (double) 50, "B"));
            itemsList.add(new Item("C", (double) 25, "C"));
            itemsList.add(new Item("D", (double) 20, "D"));

        }
        return itemsList;
    }

    public static HashMap<String, Item> getMapIdToItems() {
        if (mapIdToItems == null) {
            mapIdToItems = new HashMap<>();
            getItemsList().stream().forEach(i -> mapIdToItems.put(i.getItemId(), (Item) i));

        }
        return mapIdToItems;
    }

    /*
     again, a static list provider.. in case of a db, or persistence layer, this method would be
     a service method and would return the information from a table
     */
    public static ArrayList<PricingRule> getPricingRules() {
        ArrayList<PricingRule> rules = new ArrayList<>();
        if(itemsList==null)
            itemsList=getItemsList();
        rules.add(new PricingRule(getMapIdToItems().get("A"), 3, (double) 100));
        rules.add(new PricingRule(getMapIdToItems().get("B"), 2, (double) 80));
        return rules;
    }

    /*
    this method will always run the pricing rule and create a new list of specialPriceItems.
     */
    public static ArrayList<SpecialPriceItem> getSpecialPriceItemsByPricingRules(ArrayList<PricingRule> pricingRule) {
        specialPriceItems = new ArrayList<>();
        pricingRule.forEach(pr -> specialPriceItems.add(new SpecialPriceItem(pr.getItem(), pr.getQuantity(), pr.getPrice())));

        return specialPriceItems;
    }

}
