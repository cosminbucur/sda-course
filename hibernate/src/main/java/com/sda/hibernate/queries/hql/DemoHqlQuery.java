package com.sda.hibernate.queries.hql;

import java.util.List;

public class DemoHqlQuery {

    public static void main(String[] args) {
        StockDao stockDao = new StockDao();

        Stock stock1 = new Stock();
        stock1.setName("stock1");
        stock1.setStockCode("S0223");

        Stock stock2 = new Stock();
        stock2.setName("stock2");
        stock2.setStockCode("S0445");

        stockDao.create(stock1);
        stockDao.create(stock2);

        List<Stock> stocks = stockDao.findAllWithHqlQuery();
        System.out.println("--- all stocks: " + stocks);

        List<Stock> filteredStocks = stockDao.findAllByStockCodeWithNamedQuery(stock2.getStockCode());
        System.out.println("--- filteredStocks: " + filteredStocks);

        List<Stock> orderedStocks = stockDao.findAllOrderedByName();
        System.out.println("--- orderedStocks: " + orderedStocks);
    }
}
