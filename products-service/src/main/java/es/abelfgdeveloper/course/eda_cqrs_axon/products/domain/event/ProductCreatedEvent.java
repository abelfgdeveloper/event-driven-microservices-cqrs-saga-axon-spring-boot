package es.abelfgdeveloper.course.eda_cqrs_axon.products.domain.event;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductCreatedEvent {
  
  private String productId;
  private String title;
  private BigDecimal price;
  private Integer quantity;
  
}
