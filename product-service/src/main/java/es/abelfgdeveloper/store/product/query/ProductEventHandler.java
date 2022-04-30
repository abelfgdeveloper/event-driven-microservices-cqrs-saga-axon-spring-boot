package es.abelfgdeveloper.store.product.query;

import es.abelfgdeveloper.store.product.core.event.ProductCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {

  @EventHandler
  public void on(ProductCreatedEvent event) {}
}
