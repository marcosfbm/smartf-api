package br.com.intechsistemas.autenticador.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
  private String message;
  private String field;
  
}
