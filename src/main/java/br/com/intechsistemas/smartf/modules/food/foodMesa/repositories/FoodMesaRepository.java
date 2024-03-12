package br.com.intechsistemas.smartf.modules.food.foodMesa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechsistemas.smartf.modules.food.foodMesa.FoodMesa;

public interface FoodMesaRepository extends JpaRepository<FoodMesa, Long> {
  @SuppressWarnings("null")
  Optional<FoodMesa> findById(Long id);  

  List<FoodMesa> findByNomeContainingIgnoreCase(String filter);
}
