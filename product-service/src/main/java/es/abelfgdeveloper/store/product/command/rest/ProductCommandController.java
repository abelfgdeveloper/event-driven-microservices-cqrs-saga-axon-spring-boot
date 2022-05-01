package es.abelfgdeveloper.store.product.command.rest;

import es.abelfgdeveloper.store.product.command.CreateProductCommand;
import java.util.UUID;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductCommandController {

  private final Environment env;
  private final CommandGateway commandGateway;

  @PostMapping
  public String createProduct(@Valid @RequestBody CreateProductRestModel request) {

    CreateProductCommand command =
        CreateProductCommand.builder()
            .productId(UUID.randomUUID().toString())
            .title(request.getTitle())
            .price(request.getPrice())
            .quantity(request.getQuantity())
            .build();

    //    String returnValue = null;
    //    try {
    //      returnValue = commandGateway.sendAndWait(command);
    //    } catch (Exception ex) {
    //      returnValue = ex.getLocalizedMessage();
    //    }
    //    return returnValue;
    return commandGateway.sendAndWait(command);
  }

  //  @GetMapping
  //  public String getProduct() {
  //    return "HTTP GET Handled" + env.getProperty("local.server.port");
  //  }
  //
  //  @PutMapping
  //  public String updateProduct() {
  //    return "HTTP PUT Handled";
  //  }
  //
  //  @DeleteMapping
  //  public String deleteProduct() {
  //    return "HTTP DELETE Handled";
  //  }
}
