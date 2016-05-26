/*
* @Author: dogzz
* @Created: 5/25/2016
*/

package com.company.kata.k09checkout;

import java.util.ArrayList;
import java.util.List;

public class PriceList {
    List<Item> items = new ArrayList<>();


    public void addItem(String itemName, int price) {
        items.add(new Item(itemName, price, 0, 0));
    }

    public void addItem(String itemName, int price, int specialCount, int specialPrice) {
        items.add(new Item(itemName, price, specialCount, specialPrice));
    }

    public int getSize() {
        return items.size();
    }

    public int getItemPrice(String itemName) {
        for (Item item : items) {
            if (item.name.equals(itemName)) {
                return item.price;
            }
        }
        return 0;
    }

    public boolean isItemPresent(String itemName) {
        return items.stream().anyMatch(s -> s.name.equals(itemName));
    }

    public boolean isItemHasSpecialPrice(String itemName) {
        return items.stream().anyMatch(s -> s.name.equals(itemName) && s.specialCount > 0);
    }

    public int getItemSpecialCount(String itemName) {
        for (Item item : items) {
            if (item.name.equals(itemName)) {
                return item.specialCount;
            }
        }
        return -1;
    }

    public int getItemSpecialPrice(String itemName) {
        for (Item item : items) {
            if (item.name.equals(itemName)) {
                return item.specialPrice;
            }
        }
        return -1;
    }



    private class Item {
        String name;
        int price;
        int specialCount = 0;
        int specialPrice = 0;

        Item(String name, int price, int specialCount, int specialPrice) {
            this.name = name;
            this.price = price;
            this.specialCount = specialCount;
            this.specialPrice = specialPrice;
        }
    }
}
