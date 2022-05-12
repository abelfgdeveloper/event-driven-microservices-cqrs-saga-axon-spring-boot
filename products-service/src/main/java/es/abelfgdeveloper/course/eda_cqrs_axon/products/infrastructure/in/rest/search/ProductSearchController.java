package es.abelfgdeveloper.course.eda_cqrs_axon.products.infrastructure.in.rest.search;

import es.abelfgdeveloper.course.eda_cqrs_axon.products.domain.query.SearchProductsQuery;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductSearchController {

  private final QueryGateway queryGateway;

  @GetMapping("/products")
  public List<ProductResponseResource> execute() {
    return queryGateway
        .query(
            new SearchProductsQuery(),
            ResponseTypes.multipleInstancesOf(ProductResponseResource.class))
        .join();
  }
}
