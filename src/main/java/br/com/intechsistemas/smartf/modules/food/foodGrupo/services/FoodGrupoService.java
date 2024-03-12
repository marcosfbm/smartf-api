package br.com.intechsistemas.smartf.modules.food.foodGrupo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intechsistemas.smartf.exceptions.FoundException;
import br.com.intechsistemas.smartf.modules.food.foodGrupo.FoodGrupo;
import br.com.intechsistemas.smartf.modules.food.foodGrupo.repositories.FoodGrupoRepository;

@Service
public class FoodGrupoService {
    @Autowired
  private FoodGrupoRepository repository; 

  public FoodGrupo save(FoodGrupo object) {
    this.repository
      .findById(object.getId())
      .ifPresent((obj) -> {
        throw new FoundException("Informação já existe na base de dados!"); 
      });
    return this.repository.save(object);
  }

    public List<FoodGrupo> recuperarFiltro(String nome) {
    List<FoodGrupo> retorno = null;
    if ((nome != null) && (!nome.isEmpty())) 
      retorno = this.repository.findByNomeContainingIgnoreCase(nome);
    else
      retorno = this.repository.findAll();

    return retorno;
  }
}
