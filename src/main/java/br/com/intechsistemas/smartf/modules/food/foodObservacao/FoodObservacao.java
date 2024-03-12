package br.com.intechsistemas.smartf.modules.food.foodObservacao;

import br.com.intechsistemas.smartf.modules.food.foodGrupo.FoodGrupo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity(name="food_observacao")
public class FoodObservacao {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String nome;
  @ManyToOne()
  @JoinColumn(name ="id_grupo")
  @NotBlank(message = "Este campo é obrigatório")
  private FoodGrupo grupo;
  private Double acrescimo;
}
