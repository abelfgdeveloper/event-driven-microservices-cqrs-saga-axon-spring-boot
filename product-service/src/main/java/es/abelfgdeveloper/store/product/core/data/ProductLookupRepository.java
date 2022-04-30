package es.abelfgdeveloper.store.product.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLookupRepository extends JpaRepository<ProductLookupEntity, String> {

  ProductLookupRepository findByProductIdOrTitle(String productId, String title);
}
