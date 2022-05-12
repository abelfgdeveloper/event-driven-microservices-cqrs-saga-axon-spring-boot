package es.abelfgdeveloper.course.eda_cqrs_axon.products.infrastructure.out.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity implements Serializable {

  private static final long serialVersionUID = -8153647082731468906L;

  @Id
  @Column(name = "product_id")
  private String productId;

  @Column(name = "title", unique = true)
  private String title;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "quantity")
  private Integer quantity;
}
