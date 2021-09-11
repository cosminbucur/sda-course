package com.sda.spring.data.jpa.transactions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionsConfig {

    private static final Logger log = LoggerFactory.getLogger(TransactionsConfig.class);

    @Autowired
    private CardService cardService;

    @Bean
    public CommandLineRunner transactionsData() {
        return args -> testTransactions();
    }

    private void testTransactions() {
        Card card = new Card("name", "number");
        Card savedCard = cardService.save(card);

        Long id = savedCard.getId();

        cardService.updateTransaction(id);
//        cardService.updateTransactionWithRollback(id, true);
//        cardService.updateNameTransactionPreventRollback(id, true);
    }

}
