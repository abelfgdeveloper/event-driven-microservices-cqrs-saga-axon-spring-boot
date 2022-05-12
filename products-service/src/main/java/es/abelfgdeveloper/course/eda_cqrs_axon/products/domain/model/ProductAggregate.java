package es.abelfgdeveloper.course.eda_cqrs_axon.products.domain.model;

import es.abelfgdeveloper.course.eda_cqrs_axon.products.domain.command.CreateProductCommand;
import es.abelfgdeveloper.course.eda_cqrs_axon.products.domain.event.ProductCreatedEvent;
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
  public ProductAggregate(CreateProductCommand command) {
    if (command.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Price cannot be less or equal than zero");
    }
    if (command.getTitle() == null || command.getTitle().isBlank()) {
      throw new IllegalArgumentException("Title cannot be empty");
    }

    ProductCreatedEvent event =
        ProductCreatedEvent.builder()
            .productId(command.getProductId())
            .title(command.getTitle())
            .price(command.getPrice())
            .quantity(command.getQuantity())
            .build();

    AggregateLifecycle.apply(event);
  }

  @EventSourcingHandler
  public void on(ProductCreatedEvent event) {
    productId = event.getProductId();
    title = event.getTitle();
    price = event.getPrice();
    quantity = event.getQuantity();
  }
}
