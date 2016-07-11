/*
* @Author: dogzz
* @Created: 5/30/2016
*/

package com.company.j8inaction.trader;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TraderQueries {
    private List<Transaction> transactions;

    public TraderQueries(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    public List<Transaction> getTransactionByYearSorted(int year) {
        return transactions.stream()
                .filter(t -> t.getYear() == year)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    public List<String> getUniqueCities() {
        return transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Trader> getTradersByCitySorted(String city) {
        return transactions.stream()
                .filter(t -> t.getTrader().getCity().equals(city))
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    public String getTradersNamesSorted() {
        Optional<String> result = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce(String::concat);
        return result.orElse("");
    }

    public boolean isAnyTraderBasedInCity(String city) {
        return transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals(city));
    }

    public List<Integer> getAllTransactionValuesByCity(String city) {
        return transactions.stream()
                .filter(t -> t.getTrader().getCity().equals(city))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
    }

    public int getMaxTransactionValue() {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .orElse(-1);
    }

    public Transaction getMinTransaction() {
        return transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue()? t1 : t2)
                .orElse(null);
    }
}
