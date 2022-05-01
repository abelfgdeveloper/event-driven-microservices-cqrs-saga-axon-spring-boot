package es.abelfgdeveloper.store.product.query;

import es.abelfgdeveloper.store.product.core.data.ProductEntity;
import es.abelfgdeveloper.store.product.core.data.ProductRepository;
import es.abelfgdeveloper.store.product.core.event.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@ProcessingGroup("product-group")
public class ProductEventHandler {

  private final ProductRepository productRepository;

  @ExceptionHandler(resultType = Exception.class)
  public void handle(Exception ex) throws Exception {
    throw ex;
  }

  @ExceptionHandler(resultType = IllegalArgumentException.class)
  public void handle(IllegalArgumentException ex) {}

  @EventHandler
  public void on(ProductCreatedEvent event) throws Exception {

    ProductEntity productEntity = new ProductEntity();
    productEntity.setProductId(event.getProductId());
    productEntity.setTitle(event.getTitle());
    productEntity.setPrice(event.getPrice());
    productEntity.setQuantity(event.getQuantity());

    try {
      productRepository.save(productEntity);
    } catch (IllegalArgumentException ex) {
      ex.printStackTrace();
    }
    if (true) {
      throw new Exception("Force exception in ProductEventHandler class");
    }
  }
}
