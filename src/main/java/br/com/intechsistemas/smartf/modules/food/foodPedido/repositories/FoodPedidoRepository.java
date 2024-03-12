package br.com.intechsistemas.smartf.modules.food.foodPedido.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechsistemas.smartf.modules.food.foodPedido.FoodPedido;

public interface FoodPedidoRepository extends JpaRepository<FoodPedido, Long> {
  @SuppressWarnings("null")
  Optional<FoodPedido> findById(Long id);  
}
