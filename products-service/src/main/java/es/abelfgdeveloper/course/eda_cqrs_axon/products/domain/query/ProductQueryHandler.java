package es.abelfgdeveloper.course.eda_cqrs_axon.products.domain.query;

import es.abelfgdeveloper.course.eda_cqrs_axon.products.infrastructure.in.rest.search.ProductResponseResource;
import es.abelfgdeveloper.course.eda_cqrs_axon.products.infrastructure.out.persistence.ProductEntity;
import es.abelfgdeveloper.course.eda_cqrs_axon.products.infrastructure.out.persistence.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductQueryHandler {

  private final ProductRepository productRepository;

  @QueryHandler
  public List<ProductResponseResource> search(SearchProductsQuery query) {
    List<ProductResponseResource> products = new ArrayList<>();

    List<ProductEntity> productsSaved = productRepository.findAll();

    for (ProductEntity productEntity : productsSaved) {
      products.add(
          ProductResponseResource.builder()
              .productId(productEntity.getProductId())
              .title(productEntity.getTitle())
              .price(productEntity.getPrice())
              .quantity(productEntity.getQuantity())
              .build());
    }
    return products;
  }
}
