package br.com.intechsistemas.smartf.modules.food.foodPedidoItem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intechsistemas.smartf.exceptions.FoundException;
import br.com.intechsistemas.smartf.modules.food.foodPedidoItem.FoodPedidoItem;
import br.com.intechsistemas.smartf.modules.food.foodPedidoItem.repositories.FoodPedidoItemRepository;

@Service
public class FoodPedidoItemService {
  @Autowired
  private FoodPedidoItemRepository repository; 

  public FoodPedidoItem save(FoodPedidoItem object) {
    this.repository
      .findById(object.getId())
      .ifPresent((obj) -> {
        throw new FoundException("Informação já existe na base de dados!"); 
      });
    return this.repository.save(object);
  }

    public List<FoodPedidoItem> recuperarFiltro(String nome) {
    List<FoodPedidoItem> retorno = null;
    /*if ((nome != null) && (!nome.isEmpty())) 
      retorno = this.repository.findByNomeContainingIgnoreCase(nome);
    else*/
      retorno = this.repository.findAll();

    return retorno;
  }
}
