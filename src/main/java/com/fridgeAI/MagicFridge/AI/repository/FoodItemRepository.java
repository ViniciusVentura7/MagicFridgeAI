package com.fridgeAI.MagicFridge.AI.repository;

import com.fridgeAI.MagicFridge.AI.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}
