package com.yeshwanth;

import com.yeshwanth.model.Product;
import com.yeshwanth.repos.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootWithGraphQlApplication {


    private final ProductRepository productRepository;

    public SpringBootWithGraphQlApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {

        List<Product> products = Stream.of(
                new Product("Laptop", "Electronics", BigDecimal.valueOf(1000.00), 50),
                new Product("Smartphone", "Electronics", BigDecimal.valueOf(700.00), 150),
                new Product("Tablet", "Electronics", BigDecimal.valueOf(500.00), 120),
                new Product("Monitor", "Electronics", BigDecimal.valueOf(200.00), 80),
                new Product("Headphones", "Accessories", BigDecimal.valueOf(100.00), 200),
                new Product("Keyboard", "Accessories", BigDecimal.valueOf(50.00), 300),
                new Product("Chair", "Furniture", BigDecimal.valueOf(150.00), 40),
                new Product("Desk", "Furniture", BigDecimal.valueOf(250.00), 35),
                new Product("Backpack", "Travel", BigDecimal.valueOf(75.00), 100),
                new Product("Shoes", "Fashion", BigDecimal.valueOf(120.00), 60)
        ).toList();
        productRepository.saveAll(products);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithGraphQlApplication.class, args);
    }
}
