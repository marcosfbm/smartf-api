package br.com.intechsistemas.smartf.modules.food.foodImpressora.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intechsistemas.smartf.exceptions.FoundException;
import br.com.intechsistemas.smartf.modules.food.foodImpressora.FoodImpressora;
import br.com.intechsistemas.smartf.modules.food.foodImpressora.repositories.FoodImpressoraRepository;

@Service
public class FoodImpressoraService {
    @Autowired
  private FoodImpressoraRepository repository; 

  public FoodImpressora save(FoodImpressora object) {
    this.repository
      .findById(object.getId())
      .ifPresent((obj) -> {
        throw new FoundException("Informação já existe na base de dados!"); 
      });
    return this.repository.save(object);
  }

  public List<FoodImpressora> recuperarFiltro(String nome) {
    List<FoodImpressora> retorno = null;
    if ((nome != null) && (!nome.isEmpty())) 
      retorno = this.repository.findByNomeContainingIgnoreCase(nome);
    else
      retorno = this.repository.findAll();

    return retorno;
  }
}
