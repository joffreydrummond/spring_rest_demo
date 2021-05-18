package com.bnj.restaurant.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Food {
    private int food_id;
    private String food_name;
    private String description;
    private boolean is_gluten_free;
    private boolean is_vegan_free;
    private double price;
}
