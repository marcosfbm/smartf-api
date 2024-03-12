package br.com.intechsistemas.smartf.modules.food.foodProduto;

import br.com.intechsistemas.smartf.modules.food.foodGrupo.FoodGrupo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name="food_produto")
public class FoodProduto {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String descricao;
  private Double valor;
  private Double estoque;
  private Double custo;
 // private Boolean inativo;
  @ManyToOne()
  @JoinColumn(name ="id_grupo")
  private FoodGrupo grupo;  
}
