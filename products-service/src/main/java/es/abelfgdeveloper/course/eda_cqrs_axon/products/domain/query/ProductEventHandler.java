package es.abelfgdeveloper.course.eda_cqrs_axon.products.domain.query;

import es.abelfgdeveloper.course.eda_cqrs_axon.products.domain.event.ProductCreatedEvent;
import es.abelfgdeveloper.course.eda_cqrs_axon.products.infrastructure.out.persistence.ProductEntity;
import es.abelfgdeveloper.course.eda_cqrs_axon.products.infrastructure.out.persistence.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductEventHandler {

  private final ProductRepository productRepository;

  @EventHandler
  public void on(ProductCreatedEvent event) {
    ProductEntity productToSave =
        ProductEntity.builder()
            .productId(event.getProductId())
            .title(event.getTitle())
            .price(event.getPrice())
            .quantity(event.getQuantity())
            .build();

    productRepository.save(productToSave);
  }
}
