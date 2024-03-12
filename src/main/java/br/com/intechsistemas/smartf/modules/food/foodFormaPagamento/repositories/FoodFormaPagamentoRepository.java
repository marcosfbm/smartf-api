package br.com.intechsistemas.smartf.modules.food.foodFormaPagamento.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechsistemas.smartf.modules.food.foodFormaPagamento.FoodFormaPagamento;

public interface FoodFormaPagamentoRepository extends JpaRepository<FoodFormaPagamento, Long> {
  @SuppressWarnings("null")
  Optional<FoodFormaPagamento> findById(Long id);  

  List<FoodFormaPagamento> findByNomeContainingIgnoreCase(String filter);
}
