package es.abelfgdeveloper.course.eda_cqrs_axon.products.infrastructure.in.rest.create;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateProductRequestResource {
  
  private String title;
  private BigDecimal price;
  private Integer quantity;
  
}
