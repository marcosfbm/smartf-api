package br.com.intechsistemas.smartf.modules.food.foodProduto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intechsistemas.smartf.exceptions.FoundException;
import br.com.intechsistemas.smartf.modules.food.foodProduto.FoodProduto;
import br.com.intechsistemas.smartf.modules.food.foodProduto.repositories.FoodProdutoRepository;

@Service
public class FoodProdutoService {
  @Autowired
  private FoodProdutoRepository repository; 

  public FoodProduto save(FoodProduto object) {
    this.repository
      .findById(object.getId())
      .ifPresent((obj) -> {
        throw new FoundException("Informação já existe na base de dados!"); 
      });
    return this.repository.save(object);
  }

    public List<FoodProduto> recuperarFiltro(String nome) {
    List<FoodProduto> retorno = null;
    if ((nome != null) && (!nome.isEmpty())) 
      retorno = this.repository.findByDescricaoContainingIgnoreCase(nome);
    else
      retorno = this.repository.findAll();

    return retorno;
  }
}
