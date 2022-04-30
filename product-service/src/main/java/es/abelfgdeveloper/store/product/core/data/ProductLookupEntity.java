package es.abelfgdeveloper.store.product.core.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products_lookup")
@Data
public class ProductLookupEntity implements Serializable {

  private static final long serialVersionUID = 9109650400360054468L;

  @Id private String productId;

  @Column(unique = true)
  private String title;
}
