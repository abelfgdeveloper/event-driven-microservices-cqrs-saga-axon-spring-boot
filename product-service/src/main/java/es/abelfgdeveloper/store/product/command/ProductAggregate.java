package es.abelfgdeveloper.store.product.command;

import java.math.BigDecimal;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.spring.stereotype.Aggregate;

@NoArgsConstructor
@Aggregate
public class ProductAggregate {

  @CommandHandler
  public ProductAggregate(CreateProductCommand command) {
    // Validate Create Product Command
    if (command.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Price cannot be less or equal than zero");
    }

    if (command.getTitle() == null || command.getTitle().isBlank()) {
      throw new IllegalArgumentException("Title cannot be empty");
    }
  }
}
