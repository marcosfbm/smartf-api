package br.com.intechsistemas.smartf.modules.food.foodFormaPagamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intechsistemas.smartf.exceptions.FoundException;
import br.com.intechsistemas.smartf.modules.food.foodFormaPagamento.FoodFormaPagamento;
import br.com.intechsistemas.smartf.modules.food.foodFormaPagamento.repositories.FoodFormaPagamentoRepository;

@Service
public class FoodFormaPagamentoService {
    @Autowired
  private FoodFormaPagamentoRepository repository; 

  public FoodFormaPagamento save(FoodFormaPagamento object) {
    this.repository
      .findById(object.getId())
      .ifPresent((obj) -> {
        throw new FoundException("Informação já existe na base de dados!"); 
      });
    return this.repository.save(object);
  }

  public List<FoodFormaPagamento> recuperarFiltro(String nome) {
    List<FoodFormaPagamento> retorno = null;
    if ((nome != null) && (!nome.isEmpty())) 
      retorno = this.repository.findByNomeContainingIgnoreCase(nome);
    else
      retorno = this.repository.findAll();

    return retorno;
  }
}
