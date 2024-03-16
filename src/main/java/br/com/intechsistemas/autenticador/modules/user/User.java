package br.com.intechsistemas.autenticador.modules.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity(name="usuario")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String nome;
  private String login;
  private String senha;
  @Column(name="avatar_url")
  private String avatarUrl;
  @Column(name="base_url")
  private String baseUrl;
  private boolean ativo;
  @Transient
  private String token;
}
