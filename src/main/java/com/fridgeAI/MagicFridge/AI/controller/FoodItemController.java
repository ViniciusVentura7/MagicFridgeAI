package com.fridgeAI.MagicFridge.AI.controller;

import com.fridgeAI.MagicFridge.AI.model.FoodItem;
import com.fridgeAI.MagicFridge.AI.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/list")
    public ResponseEntity<List<FoodItem>> getAll() {
        return ResponseEntity.ok(foodItemService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<FoodItem> addFood(@RequestBody FoodItem food) {
        FoodItem savedFood = foodItemService.save(food);
        return ResponseEntity.ok(savedFood);
    }

    @PutMapping("/change")
    public ResponseEntity<FoodItem> changeFood(@PathVariable Long id, @RequestBody FoodItem food) {
        FoodItem updatedFood = foodItemService.change(id, food);
        return ResponseEntity.ok(updatedFood);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        foodItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
