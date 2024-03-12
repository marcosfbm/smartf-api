package br.com.intechsistemas.smartf.modules.food.foodPedido.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intechsistemas.smartf.exceptions.FoundException;
import br.com.intechsistemas.smartf.modules.food.foodPedido.FoodPedido;
import br.com.intechsistemas.smartf.modules.food.foodPedido.repositories.FoodPedidoRepository;

@Service
public class FoodPedidoService {
  @Autowired
  private FoodPedidoRepository repository; 

  public FoodPedido save(FoodPedido object) {
    this.repository
      .findById(object.getId())
      .ifPresent((obj) -> {
        throw new FoundException("Informação já existe na base de dados!"); 
      });
    return this.repository.save(object);
  }

    public List<FoodPedido> recuperarFiltro(String nome) {
    List<FoodPedido> retorno = null;
    /*if ((nome != null) && (!nome.isEmpty())) 
      retorno = this.repository.findByNomeContainingIgnoreCase(nome);
    else*/
      retorno = this.repository.findAll();

    return retorno;
  }
}
