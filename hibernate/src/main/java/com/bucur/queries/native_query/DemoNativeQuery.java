package com.bucur.queries.native_query;

import com.bucur.queries.hql.Stock;

import java.util.List;

public class DemoNativeQuery {

    public static void main(String[] args) {
        TraderDao traderDao = new TraderDao();

        Trader trader1 = new Trader();
        trader1.setName("smith");

        Trader trader2 = new Trader();
        trader2.setName("baker");

        traderDao.create(trader1);
        traderDao.create(trader2);

        List<Stock> traders = traderDao.findAllWithNativeQuery();
        System.out.println("--- all traders: " + traders);

        List<Stock> filteredTraders = traderDao.findAllByNameWithNamedNativeQuery(trader1.getName());
        System.out.println("--- filtered traders: " + filteredTraders);
    }
}
