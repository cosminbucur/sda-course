package com.sda.spring.thymeleaf.controller;

import com.sda.spring.thymeleaf.model.Product;
import com.sda.spring.thymeleaf.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// mvc controller
@Controller
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String showProductsPage(Model model) {
        log.info("Show products page");
        // get data
        List<Product> foundProducts = productService.findAll();

        // put data on model to have it available in html
        model.addAttribute("products", foundProducts);

        return "index";
    }

    @GetMapping("/new")
    public String showNewProductPage(Model model) {
        log.info("Show new product page");

        Product product = new Product();
        model.addAttribute("product", product);

        return "product-add";
    }

    @PostMapping("/save")
    public String saveProduct(
        @ModelAttribute("product") Product product) {

        log.info("action: save new product");
        productService.save(product);

        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditProductPage(
        @PathVariable(name = "id") int id) {

        log.info("show edit product page");
        // find product
        Product foundProduct = productService.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("no such id " + id));

        // add product to ModelAndView
        ModelAndView modelAndView = new ModelAndView("product-edit");
        modelAndView.addObject("product", foundProduct);

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(
        @PathVariable(name = "id") long id) {

        log.info("delete product with id {}", id);
        productService.delete(id);

        return "redirect:/products";
    }
}
