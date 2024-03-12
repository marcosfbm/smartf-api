package br.com.intechsistemas.smartf.modules.food.foodObservacao.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.intechsistemas.smartf.modules.food.foodObservacao.FoodObservacao;
import br.com.intechsistemas.smartf.modules.food.foodObservacao.services.FoodObservacaoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/food/foodobservacao")
public class FoodObservacaoController {

  @Autowired
  private FoodObservacaoService service;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody FoodObservacao object, HttpServletRequest request){
    //caso eu precise pegar idParcipante ou outra informacao vou usar o que esta dentro de, HttpServletRequest request
    try{
      var result = this.service.save(object);
      return ResponseEntity.ok().body(result);
    } catch(Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } 
  }

    @GetMapping("/recuperar")
  //@PreAuthorize("hasRole('PARTICIPANTE')")
  public List<FoodObservacao> recuperar(@RequestParam(required = false) String nome) {
      return this.service.recuperarFiltro(nome);
  }
}
