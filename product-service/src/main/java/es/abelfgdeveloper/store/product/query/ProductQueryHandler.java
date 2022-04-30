package es.abelfgdeveloper.store.product.query;

import es.abelfgdeveloper.store.product.core.data.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductQueryHandler {

  private final ProductRepository productRepository;
}
