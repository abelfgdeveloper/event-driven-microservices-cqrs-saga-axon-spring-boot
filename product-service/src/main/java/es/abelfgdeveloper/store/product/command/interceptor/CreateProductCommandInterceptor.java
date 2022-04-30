package es.abelfgdeveloper.store.product.command.interceptor;

import es.abelfgdeveloper.store.product.command.CreateProductCommand;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiFunction;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateProductCommandInterceptor
    implements MessageDispatchInterceptor<CommandMessage<?>> {

  @Override
  public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(
      List<? extends CommandMessage<?>> messages) {
    return (index, command) -> {
      log.info("Intercepted command: " + command.getPayloadType());
      if (CreateProductCommand.class.equals(command.getPayloadType())) {
        CreateProductCommand createProductCommand = (CreateProductCommand) command.getPayload();
        if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
          throw new IllegalArgumentException("Price cannot be less or equal than zero");
        }
        if (createProductCommand.getTitle() == null || createProductCommand.getTitle().isBlank()) {
          throw new IllegalArgumentException("Title cannot be empty");
        }
      }

      return command;
    };
  }
}
