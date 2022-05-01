package es.abelfgdeveloper.store.product.command;

import es.abelfgdeveloper.store.product.core.data.ProductLookupEntity;
import es.abelfgdeveloper.store.product.core.data.ProductLookupRepository;
import es.abelfgdeveloper.store.product.core.event.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductLookupEventHandler {

  private final ProductLookupRepository productLookupRepository;

  @EventHandler
  public void on(ProductCreatedEvent event) {
    ProductLookupEntity productLookupEntity =
        new ProductLookupEntity(event.getProductId(), event.getTitle());
    productLookupRepository.save(productLookupEntity);
  }
}
