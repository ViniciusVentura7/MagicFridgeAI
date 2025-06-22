package com.fridgeAI.MagicFridge.AI.controller;

import com.fridgeAI.MagicFridge.AI.model.FoodItem;
import com.fridgeAI.MagicFridge.AI.service.FoodItemService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @GetMapping
    public List<FoodItem> getAll(){return foodItemService.getAll();}

    @PostMapping
    public FoodItem create(@RequestBody FoodItem food) { return foodItemService.save(food); }

}
