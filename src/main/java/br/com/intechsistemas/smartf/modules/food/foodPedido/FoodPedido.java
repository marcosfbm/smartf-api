package br.com.intechsistemas.smartf.modules.food.foodPedido;

import java.util.Date;

import br.com.intechsistemas.smartf.modules.food.foodPedido.FoodPedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="food_pedido")
public class FoodPedido {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private Date data;
  @Column(name = "numero_mesa")
  private int numeroMesa;
  private String observacao;
  @Column(name = "id_forma_pagamento")
  private int idFormaPagamento; 
  @Column(name = "id_garcon")
  private int idGarcon; 
  @Column(name = "id_cliente")
  private int idCliente; 
  private int bonificacao;
  private Double total;
  private Double desconto;
  private Double troco;
  private Double acrescimo;
  private int delivery;
  @Column(name = "id_terminal")
  private int idTerminal;
  private Double dinheiro;
  @Column(name = "pagto_parcial_mesa")
  private Double pagtoParcialMesa;
}