package es.abelfgdeveloper.course.eda_cqrs_axon.products.config.axon;

import es.abelfgdeveloper.course.eda_cqrs_axon.products.domain.command.CreateProductCommandInterceptor;
import org.axonframework.commandhandling.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfiguration {

  @Autowired
  public void registerCreateProductCommandInterceptor(
      ApplicationContext context, CommandBus commandBus) {
    commandBus.registerDispatchInterceptor(context.getBean(CreateProductCommandInterceptor.class));
  }
}
