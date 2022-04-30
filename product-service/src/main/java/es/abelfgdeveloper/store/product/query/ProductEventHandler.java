package es.abelfgdeveloper.store.product.query;

import es.abelfgdeveloper.store.product.core.data.ProductEntity;
import es.abelfgdeveloper.store.product.core.data.ProductRepository;
import es.abelfgdeveloper.store.product.core.event.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductEventHandler {

  private final ProductRepository productRepository;

  @EventHandler
  public void on(ProductCreatedEvent event) {
    ProductEntity productEntity = new ProductEntity();
    productEntity.setProductId(event.getProductId());
    productEntity.setTitle(event.getTitle());
    productEntity.setPrice(event.getPrice());
    productEntity.setQuantity(event.getQuantity());

    productRepository.save(productEntity);
  }
}
