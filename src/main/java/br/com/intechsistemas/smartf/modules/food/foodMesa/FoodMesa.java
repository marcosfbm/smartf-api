package br.com.intechsistemas.smartf.modules.food.foodMesa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="food_mesa")
public class FoodMesa {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String nome;
  private int aberta;
  @Column(name="pagto_parcial")
  private Double parcial;
  @Column(name="qtd_pedidos")
  private int qtdPedidos;
  @Column(name="qtd_itens")
  private double qtdItens;
  private double total;
  private boolean ocupado;
}
