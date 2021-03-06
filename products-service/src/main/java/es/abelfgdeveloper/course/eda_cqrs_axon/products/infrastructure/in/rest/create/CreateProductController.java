package es.abelfgdeveloper.course.eda_cqrs_axon.products.infrastructure.in.rest.create;

import es.abelfgdeveloper.course.eda_cqrs_axon.products.domain.command.CreateProductCommand;
import java.util.UUID;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CreateProductController {

  private final CommandGateway commandGateway;

  @PostMapping("/products")
  @ResponseStatus(HttpStatus.CREATED)
  public CreateProductResponseResource execute(
      @Valid @RequestBody CreateProductRequestResource request) {
    CreateProductCommand command =
        CreateProductCommand.builder()
            .productId(UUID.randomUUID().toString())
            .title(request.getTitle())
            .price(request.getPrice())
            .quantity(request.getQuantity())
            .build();
    try {
      String productId = commandGateway.sendAndWait(command);
      return CreateProductResponseResource.builder().productId(productId).build();
    } catch (Exception e) {
      log.error("Exception: {}", e);
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
    }
  }
}
