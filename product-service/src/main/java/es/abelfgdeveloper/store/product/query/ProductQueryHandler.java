package es.abelfgdeveloper.store.product.query;

import es.abelfgdeveloper.store.product.core.data.ProductEntity;
import es.abelfgdeveloper.store.product.core.data.ProductRepository;
import es.abelfgdeveloper.store.product.query.rest.ProductRestModel;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductQueryHandler {

  private final ProductRepository productRepository;

  @QueryHandler
  public List<ProductRestModel> findProducts(FindProductsQuery query) {
    List<ProductRestModel> productsRest = new ArrayList<>();

    List<ProductEntity> storedProducts = productRepository.findAll();

    for (ProductEntity productEntity : storedProducts) {
      ProductRestModel productRestModel = new ProductRestModel();
      productRestModel.setProductId(productEntity.getProductId());
      productRestModel.setTitle(productEntity.getTitle());
      productRestModel.setPrice(productEntity.getPrice());
      productRestModel.setQuantity(productEntity.getQuantity());
      productsRest.add(productRestModel);
    }

    return productsRest;
  }
}
