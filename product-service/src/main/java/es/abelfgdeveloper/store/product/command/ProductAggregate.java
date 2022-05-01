package es.abelfgdeveloper.store.product.command;

import es.abelfgdeveloper.store.product.core.event.ProductCreatedEvent;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@NoArgsConstructor
@Aggregate
public class ProductAggregate {

  @AggregateIdentifier private String productId;
  private String title;
  private BigDecimal price;
  private Integer quantity;

  @CommandHandler
  public ProductAggregate(CreateProductCommand command) throws Exception {
    // Validate Create Product Command

    ProductCreatedEvent createdEvent = new ProductCreatedEvent();
    createdEvent.setProductId(command.getProductId());
    createdEvent.setTitle(command.getTitle());
    createdEvent.setPrice(command.getPrice());
    createdEvent.setQuantity(command.getQuantity());

    AggregateLifecycle.apply(createdEvent);

    if (true) {
      throw new Exception("An Error took place in the CreateProductCommand");
    }
  }

  @EventSourcingHandler
  public void on(ProductCreatedEvent event) {
    this.productId = event.getProductId();
    this.title = event.getTitle();
    this.price = event.getPrice();
    this.quantity = event.getQuantity();
  }
}
