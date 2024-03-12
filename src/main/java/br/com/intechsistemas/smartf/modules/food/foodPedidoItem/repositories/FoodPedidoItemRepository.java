package br.com.intechsistemas.smartf.modules.food.foodPedidoItem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechsistemas.smartf.modules.food.foodPedidoItem.FoodPedidoItem;

public interface FoodPedidoItemRepository extends JpaRepository<FoodPedidoItem, Long> {
  @SuppressWarnings("null")
  Optional<FoodPedidoItem> findById(Long id);  

}
