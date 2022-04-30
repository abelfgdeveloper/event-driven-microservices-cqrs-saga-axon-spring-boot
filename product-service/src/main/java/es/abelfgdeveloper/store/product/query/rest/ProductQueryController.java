package es.abelfgdeveloper.store.product.query.rest;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

  @GetMapping
  public List<ProductRestModel> getProducts() {}
}
