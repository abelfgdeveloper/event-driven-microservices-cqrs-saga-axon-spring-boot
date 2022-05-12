package es.abelfgdeveloper.course.eda_cqrs_axon.products.infrastructure.in.rest.search;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ProductResponseResource {

  private String productId;
  private String title;
  private BigDecimal price;
  private Integer quantity;
}
