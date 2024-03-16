package br.com.intechsistemas.autenticador.modules.user.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechsistemas.autenticador.modules.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
  @SuppressWarnings("null")
  Optional<User> findById(Long id); 
  Optional<User> findByLogin(String login);
  List<User> findByNomeContainingIgnoreCase(String filter);
}
