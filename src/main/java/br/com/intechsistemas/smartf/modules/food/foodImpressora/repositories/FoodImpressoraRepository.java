package br.com.intechsistemas.smartf.modules.food.foodImpressora.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechsistemas.smartf.modules.food.foodImpressora.FoodImpressora;

public interface FoodImpressoraRepository extends JpaRepository<FoodImpressora, Long> {
  @SuppressWarnings("null")
  Optional<FoodImpressora> findById(Long id);  

  List<FoodImpressora> findByNomeContainingIgnoreCase(String filter);
}
