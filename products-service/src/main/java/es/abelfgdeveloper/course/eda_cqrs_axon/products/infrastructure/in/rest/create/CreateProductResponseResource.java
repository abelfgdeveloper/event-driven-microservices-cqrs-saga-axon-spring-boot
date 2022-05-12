package es.abelfgdeveloper.course.eda_cqrs_axon.products.infrastructure.in.rest.create;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateProductResponseResource {

  private String productId;
}
