package br.com.intechsistemas.smartf.modules.food.foodMesa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.intechsistemas.smartf.modules.food.foodMesa.FoodMesa;
import br.com.intechsistemas.smartf.modules.food.foodMesa.services.FoodMesaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/food/foodmesa")
public class FoodMesaController {

  @Autowired
  private FoodMesaService service;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody FoodMesa object, HttpServletRequest request){
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
  public List<FoodMesa> recuperar(@RequestParam(required = false) String nome) {
      return this.service.recuperarFiltro(nome);
  }
}
