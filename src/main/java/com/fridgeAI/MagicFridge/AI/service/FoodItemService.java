package com.fridgeAI.MagicFridge.AI.service;


import com.fridgeAI.MagicFridge.AI.model.FoodItem;
import com.fridgeAI.MagicFridge.AI.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    //Listar
    public List<FoodItem> getAll(){return foodItemRepository.findAll();}

    //Criar
    public FoodItem save(FoodItem food) { return  foodItemRepository.save(food);}

    //Deletar
    public void delete(Long id) { foodItemRepository.deleteById(id);}


}
