package com.yeshwanth.graphqlclient.controller;

import com.yeshwanth.graphqlclient.model.Item;
import com.yeshwanth.graphqlclient.model.ProductRequest;
import com.yeshwanth.graphqlclient.service.CategoryService;
import com.yeshwanth.graphqlclient.service.InventoryClient;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GraphqlClientController {

private final CategoryService categoryService;

    @GetMapping("/products")
    public List<Item> viewProducts() {
     return categoryService.viewProducts();
    }


    @GetMapping("/products/category")
    public List<Item> getCatalogDetails(@RequestParam String category) {
        return categoryService.viewCategories(category);
    }


    @PostMapping ("/Shipment")
    public Item receiveShipment(@RequestBody ProductRequest productRequest) {
        return categoryService.updateStockQuntity(productRequest);
    }


}
