/*
* @Author: dogzz
* @Created: 5/25/2016
*/

package com.company.kata.k09checkout;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckOut {
    private PriceList priceList;
    private int total;
    private List<String> scannedItem;

    public CheckOut(PriceList priceList) {
        this.priceList = priceList;
        this.total = 0;
        this.scannedItem = new ArrayList<>();
    }

    public int getTotal() {
        return total;
    }

    public void scan(String itemName) {
        if (priceList.isItemPresent(itemName)) {
            total += priceList.getItemPrice(itemName);
            processSpecialPrices(itemName);
        }
    }

    private void processSpecialPrices(String itemName) {
        scannedItem.add(itemName);
        if (priceList.isItemHasSpecialPrice(itemName)) {
            int specialCount = priceList.getItemSpecialCount(itemName);
            int processedCount = scannedItem.stream().filter(s -> s.equals(itemName)).collect(Collectors.toList()).size();
            if (processedCount == specialCount) {
                total = total - priceList.getItemPrice(itemName) * specialCount;
                int specialPrice = priceList.getItemSpecialPrice(itemName);
                total += specialPrice;
                for (int i = 0; i < processedCount; i++) {
                    scannedItem.remove(itemName);
                }
            }
        }
    }
}
