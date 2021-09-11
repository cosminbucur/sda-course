package com.sda.spring.data.jpa.association;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssociationConfig {

    private static final Logger log = LoggerFactory.getLogger(AssociationConfig.class);

    @Autowired
    private FatherRepository fatherRepository;

    @Autowired
    private SonRepository sonRepository;

    @Bean
    public CommandLineRunner associationsData() {
        return args -> testAssociations();
    }

    private void testAssociations() {
        Son son1 = new Son("son1");
        Son son2 = new Son("son2");

        Father father = new Father("father");

        father.addSon(son1);
        father.addSon(son2);

        fatherRepository.save(father);
        log.info("father repository size: {}", fatherRepository.count());
        log.info("son repository size: {}", sonRepository.count());
    }

}
