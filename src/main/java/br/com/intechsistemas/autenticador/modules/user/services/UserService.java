package br.com.intechsistemas.autenticador.modules.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.intechsistemas.autenticador.exceptions.FoundException;
import br.com.intechsistemas.autenticador.modules.user.User;
import br.com.intechsistemas.autenticador.modules.user.repositories.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository repository; 

  @Autowired
  private PasswordEncoder passwordEncoder;

  public User save(User object) {
    this.repository
      .findByLogin(object.getLogin())
      .ifPresent((obj) -> {
        throw new FoundException("Usuário já existe na base de dados!"); 
      });
      var password = passwordEncoder.encode(object.getSenha());
      object.setSenha(password);

    return this.repository.save(object);
  }

    public List<User> recuperarFiltro(String nome) {
    List<User> retorno = null;
    if ((nome != null) && (!nome.isEmpty())) 
      retorno = this.repository.findByNomeContainingIgnoreCase(nome);
    else
      retorno = this.repository.findAll();

    return retorno;
  }
}
