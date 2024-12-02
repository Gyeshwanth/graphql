package com.yeshwanth.graphqlclient.service;

import com.yeshwanth.graphqlclient.model.Item;
import com.yeshwanth.graphqlclient.model.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService {

    private final InventoryClient inventoryClient;

    public List<Item> viewProducts(){

        return inventoryClient.viewProductsInfo().stream()
                .map(e -> {
                    e.setPrice(new BigDecimal(String.valueOf(e.getPrice()))
                            .setScale(2, RoundingMode.HALF_UP).toPlainString());
                    return e;
                })
                .toList();
    }

    public List<Item> viewCategories(String category){
        return inventoryClient.viewCategory(category)
                .stream().map(c->{
                       c.setPrice(new BigDecimal(String.valueOf(c.getPrice()))
                             .setScale(2, RoundingMode.HALF_UP).toPlainString());
                    return c;
                }).toList();
    }

    public Item updateStockQuntity(ProductRequest productRequest){
        Item item = inventoryClient.IncremStock(productRequest);
        item.setPrice(new BigDecimal(String.valueOf(productRequest.getStock()))
                .setScale(2, RoundingMode.HALF_UP).toPlainString());
        return item;
    }

}
