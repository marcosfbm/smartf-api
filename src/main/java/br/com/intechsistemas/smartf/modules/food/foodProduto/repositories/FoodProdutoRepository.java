package br.com.intechsistemas.smartf.modules.food.foodProduto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechsistemas.smartf.modules.food.foodProduto.FoodProduto;

public interface FoodProdutoRepository extends JpaRepository<FoodProduto, Long> {
  @SuppressWarnings("null")
  Optional<FoodProduto> findById(Long id);  

  List<FoodProduto> findByDescricaoContainingIgnoreCase(String filter);
}
