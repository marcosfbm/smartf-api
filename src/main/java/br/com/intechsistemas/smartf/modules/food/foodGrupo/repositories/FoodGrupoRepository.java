package br.com.intechsistemas.smartf.modules.food.foodGrupo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechsistemas.smartf.modules.food.foodGrupo.FoodGrupo;

public interface FoodGrupoRepository extends JpaRepository<FoodGrupo, Long> {
  @SuppressWarnings("null")
  Optional<FoodGrupo> findById(Long id);  

  List<FoodGrupo> findByNomeContainingIgnoreCase(String filter);
}
