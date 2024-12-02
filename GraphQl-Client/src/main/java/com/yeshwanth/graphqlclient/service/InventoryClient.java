package com.yeshwanth.graphqlclient.service;

import com.yeshwanth.graphqlclient.model.Item;
import com.yeshwanth.graphqlclient.model.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InventoryClient {

    private final HttpGraphQlClient graphQlClient;


    public List<Item> viewProductsInfo() {

        String query = "query GetProducts {\n" +
                "  getAllProducts {\n" +
                "    name\n" +
                "    price\n" +
                "  }\n" +
                "}";
        return graphQlClient.document(query).retrieve("getAllProducts")
                .toEntityList(Item.class).block();
    }


    public List<Item> viewCategory(String category) {

        String query = String.format("query GeProducts {\n" +
                "  getProductsByCategory(category: \"%s\") {\n" +
                "    name\n" +
                "    category\n" +
                "    price\n" +
                "    stock\n" +
                "  }\n" +
                "}", category);
        return graphQlClient.document(query).retrieve("getProductsByCategory")
                .toEntityList(Item.class).block();
    }


    public Item IncremStock(ProductRequest productRequest) {

        String query = String.format("mutation UpdateStock {\n" +
                "  incrementProductStock(id: \"%d\", quntity: %d) {\n" +
                "    name\n" +
                "    price\n" +
                "    stock\n" +
                "  }\n" +
                "}", productRequest.getProductId(), productRequest.getStock());

        return graphQlClient.document(query).retrieve("incrementProductStock")
                .toEntity(Item.class).block();
    }

    }



