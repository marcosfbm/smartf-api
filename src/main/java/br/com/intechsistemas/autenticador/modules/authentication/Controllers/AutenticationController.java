package br.com.intechsistemas.autenticador.modules.authentication.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.intechsistemas.autenticador.modules.authentication.dto.AuthenticationDTO;
import br.com.intechsistemas.autenticador.modules.authentication.services.Authentication;


@RestController
@RequestMapping("/auth")
public class AutenticationController {

  @Autowired
  private Authentication authentication;

  @PostMapping("/sessions")
  public ResponseEntity<Object> create(@RequestBody AuthenticationDTO objeto) {
    try{
      var result = this.authentication.execute(objeto);
      return ResponseEntity.ok(result);
    }catch(Exception e){
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }   
  }
}
