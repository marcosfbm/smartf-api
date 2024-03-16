package br.com.intechsistemas.autenticador.modules.authentication.services;

import java.time.Duration;
import java.time.Instant;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.intechsistemas.autenticador.modules.authentication.dto.AuthenticationDTO;
import br.com.intechsistemas.autenticador.modules.user.User;
import br.com.intechsistemas.autenticador.modules.user.repositories.UserRepository;

@Service
public class Authentication {

  @Value("${security.token.secret}")
  private String secretykey;
  @Autowired
  private UserRepository repository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public User execute(AuthenticationDTO authenticationDTO) throws AuthenticationException{
    var user = this.repository.findByLogin(authenticationDTO.getUsername()).orElseThrow(
      () -> {
        throw new UsernameNotFoundException("Usuário não encontrado!");
      }
    );

    var passwordMatches  = this.passwordEncoder.matches(authenticationDTO.getPassword(), user.getSenha());

    if (!passwordMatches){
      throw new AuthenticationException();
    }

    Algorithm algorithm = Algorithm.HMAC256(secretykey);
    var token = JWT.create().withIssuer("autenticador")
      .withExpiresAt(Instant.now().plus(Duration.ofHours(24)))
      .withSubject(user.getId().toString()) 
      .sign(algorithm);
      user.setToken(token);

    return user;
  }
  
}
