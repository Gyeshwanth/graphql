package com.yeshwanth.service;

import com.yeshwanth.repos.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.yeshwanth.model.Product;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

private final ProductRepository productRepository;


 public List<Product>  getAllProducts(){
     return productRepository.findAll();
 }

 public List<Product> getProductsByCategory(String category){
     return productRepository.findByCategory(category);
 }

}
