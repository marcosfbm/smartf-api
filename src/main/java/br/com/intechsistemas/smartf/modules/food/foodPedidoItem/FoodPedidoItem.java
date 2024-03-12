package br.com.intechsistemas.smartf.modules.food.foodPedidoItem;

import br.com.intechsistemas.smartf.modules.food.foodPedidoItem.FoodPedidoItem;
import br.com.intechsistemas.smartf.modules.food.foodProduto.FoodProduto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity(name="food_item_pedido")
public class FoodPedidoItem {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  @Column(name = "id_pedido")
  private Long idPedido;
  private Double quantidade;
  private Double valor;
  private String observacao;
  @ManyToOne()
  @JoinColumn(name ="id_produto")
  @NotBlank(message = "Este campo é obrigatório")
  private FoodProduto produto;
}