package es.abelfgdeveloper.course.eda_cqrs_axon.products.infrastructure.out.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

  Optional<ProductEntity> findByProductId(String productId);

  Optional<ProductEntity> findByProductIdOrTitle(String productId, String title);
}
