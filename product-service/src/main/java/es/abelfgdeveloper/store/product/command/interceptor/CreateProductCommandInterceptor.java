package es.abelfgdeveloper.store.product.command.interceptor;

import es.abelfgdeveloper.store.product.command.CreateProductCommand;
import es.abelfgdeveloper.store.product.core.data.ProductLookupEntity;
import es.abelfgdeveloper.store.product.core.data.ProductLookupRepository;
import java.util.List;
import java.util.function.BiFunction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class CreateProductCommandInterceptor
    implements MessageDispatchInterceptor<CommandMessage<?>> {

  private final ProductLookupRepository productLookupRepository;

  @Override
  public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(
      List<? extends CommandMessage<?>> messages) {
    return (index, command) -> {
      log.info("Intercepted command: " + command.getPayloadType());
      if (CreateProductCommand.class.equals(command.getPayloadType())) {
        CreateProductCommand createProductCommand = (CreateProductCommand) command.getPayload();
        ProductLookupEntity productLookupEntity =
            productLookupRepository.findByProductIdOrTitle(
                createProductCommand.getProductId(), createProductCommand.getTitle());
        if (productLookupEntity != null) {
          throw new IllegalArgumentException(
              String.format(
                  "Product with productId %s or title %s already exist",
                  createProductCommand.getProductId(), createProductCommand.getTitle()));
        }
      }

      return command;
    };
  }
}
