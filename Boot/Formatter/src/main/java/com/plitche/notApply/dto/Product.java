package com.plitche.notApply.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;
    private String name;
    private int price;
    private int stock;
    private String serialNo;
    private String description;

}
