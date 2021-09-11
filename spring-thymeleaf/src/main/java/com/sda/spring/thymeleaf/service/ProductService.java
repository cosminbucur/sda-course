package com.sda.spring.thymeleaf.service;

import com.sda.spring.thymeleaf.model.Product;
import com.sda.spring.thymeleaf.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        log.info("finding all products");
        return repository.findAll();
    }

    @Transactional
    public void save(Product product) {
        log.info("saving product: {}", product);
        repository.save(product);
    }

    public Optional<Product> findById(long id) {
        log.info("finding by id: {}", id);
        return repository.findById(id);
    }

    @Transactional
    public void delete(Long id) {
        log.info("deleting product with id: {}", id);
        repository.deleteById(id);
    }
}
