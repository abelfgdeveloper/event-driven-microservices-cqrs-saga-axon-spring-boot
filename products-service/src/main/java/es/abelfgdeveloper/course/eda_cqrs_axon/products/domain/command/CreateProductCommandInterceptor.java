package es.abelfgdeveloper.course.eda_cqrs_axon.products.domain.command;

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
      if (CreateProductCommand.class.equals(command.getPayloadType())) {
        log.info("Interceptor of CreateProductCommand");
      }
      return command;
    };
  }
}
