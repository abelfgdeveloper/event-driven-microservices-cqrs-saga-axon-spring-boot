package es.abelfgdeveloper.store.product.query.rest;

import es.abelfgdeveloper.store.product.query.FindProductsQuery;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductQueryController {

  private final QueryGateway queryGateway;

  @GetMapping
  public List<ProductRestModel> getProducts() {
    FindProductsQuery findProductsQuery = new FindProductsQuery();
    List<ProductRestModel> products =
        queryGateway
            .query(findProductsQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class))
            .join();
    return products;
  }
}
