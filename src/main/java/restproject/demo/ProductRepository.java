package restproject.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import restproject.demo.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
