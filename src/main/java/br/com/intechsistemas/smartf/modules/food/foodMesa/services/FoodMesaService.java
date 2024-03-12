package br.com.intechsistemas.smartf.modules.food.foodMesa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intechsistemas.smartf.exceptions.FoundException;
import br.com.intechsistemas.smartf.modules.food.foodMesa.FoodMesa;
import br.com.intechsistemas.smartf.modules.food.foodMesa.repositories.FoodMesaRepository;

@Service
public class FoodMesaService {
    @Autowired
  private FoodMesaRepository repository; 

  public FoodMesa save(FoodMesa object) {
    this.repository
      .findById(object.getId())
      .ifPresent((obj) -> {
        throw new FoundException("Informação já existe na base de dados!"); 
      });
    return this.repository.save(object);
  }

    public List<FoodMesa> recuperarFiltro(String nome) {
    List<FoodMesa> retorno = null;
    if ((nome != null) && (!nome.isEmpty())) 
      retorno = this.repository.findByNomeContainingIgnoreCase(nome);
    else
      retorno = this.repository.findAll();

    return retorno;
  }
}
