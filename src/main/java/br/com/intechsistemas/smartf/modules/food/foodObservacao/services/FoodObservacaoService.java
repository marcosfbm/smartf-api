package br.com.intechsistemas.smartf.modules.food.foodObservacao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intechsistemas.smartf.exceptions.FoundException;
import br.com.intechsistemas.smartf.modules.food.foodObservacao.FoodObservacao;
import br.com.intechsistemas.smartf.modules.food.foodObservacao.repositories.FoodObservacaoRepository;

@Service
public class FoodObservacaoService {
    @Autowired
  private FoodObservacaoRepository repository; 

  public FoodObservacao save(FoodObservacao object) {
    this.repository
      .findById(object.getId())
      .ifPresent((obj) -> {
        throw new FoundException("Informação já existe na base de dados!"); 
      });
    return this.repository.save(object);
  }

    public List<FoodObservacao> recuperarFiltro(String nome) {
    List<FoodObservacao> retorno = null;
    if ((nome != null) && (!nome.isEmpty())) 
      retorno = this.repository.findByNomeContainingIgnoreCase(nome);
    else
      retorno = this.repository.findAll();

    return retorno;
  }
}
