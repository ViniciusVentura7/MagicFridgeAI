package com.fridgeAI.MagicFridge.AI.service;


import com.fridgeAI.MagicFridge.AI.model.FoodItem;
import com.fridgeAI.MagicFridge.AI.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    //Listar
    public List<FoodItem> getAll() {
        return foodItemRepository.findAll();
    }

    //Listar por id
    public FoodItem listFoodById(Long id) {
        Optional<FoodItem> foodById = foodItemRepository.findById(id);
        return foodById.orElse(null);
    }

    //Criar
    public FoodItem save(FoodItem food) {
        return foodItemRepository.save(food);
    }

    //Deletar
    public void delete(Long id) {
        foodItemRepository.deleteById(id);
    }

    //Alterar
    public FoodItem change(Long id, FoodItem food) {
        FoodItem updatedFood = foodItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found."));
        updatedFood.setId(food.getId());
        updatedFood.setName(food.getName());
        updatedFood.setCategory(food.getCategory());
        updatedFood.setExpirationDate(food.getExpirationDate());

        return foodItemRepository.save(updatedFood);
    }

}
