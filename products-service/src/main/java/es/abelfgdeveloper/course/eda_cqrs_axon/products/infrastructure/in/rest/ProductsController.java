package es.abelfgdeveloper.course.eda_cqrs_axon.products.infrastructure.in.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {
  
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public String createProduct() {
    return "HTTP POST Handled";
  }
  
  @GetMapping
  public String getProduct() {
    return "HTTP GET Handled";
  }
  
  
  @PutMapping
  public String updateProduct() {
    return "HTTP PUT Handled";
  }
  
  @DeleteMapping
  public String deleteProduct() {
    return "HTTP DELETE Handled";
  }
}
