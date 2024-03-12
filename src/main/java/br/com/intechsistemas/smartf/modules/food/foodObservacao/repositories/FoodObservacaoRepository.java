package br.com.intechsistemas.smartf.modules.food.foodObservacao.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechsistemas.smartf.modules.food.foodObservacao.FoodObservacao;

public interface FoodObservacaoRepository extends JpaRepository<FoodObservacao, Long> {
  @SuppressWarnings("null")
  Optional<FoodObservacao> findById(Long id);  

  List<FoodObservacao> findByNomeContainingIgnoreCase(String filter);
}
