package com.yeshwanth.graphqlclient.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;



@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Item {

    private String name;
    private String price;
    private String category;
    private String stock;

}
