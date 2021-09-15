package com.sda.hibernate.queries.native_query;

import java.util.List;

public class DemoNativeQuery {

    public static void main(String[] args) {
        TraderDao traderDao = new TraderDao();

        Trader trader1 = new Trader();
        trader1.setName("trader1");

        Trader trader2 = new Trader();
        trader2.setName("trader2");

        traderDao.create(trader1);
        traderDao.create(trader2);

        List<Trader> traders = traderDao.findAllWithNativeQuery();
        System.out.println("--- all traders: " + traders);

        List<Trader> filteredTraders = traderDao.findAllByNameWithNamedNativeQuery(trader1.getName());
        System.out.println("--- filtered traders: " + filteredTraders);
    }
}
