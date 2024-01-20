package com.jsz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    private int id;
    private String name;
    private float price;
    private float count;
    private String publish;

}
