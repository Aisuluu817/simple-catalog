package restproject.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    List<Product> all() {
            return repository.findAll();
    }
    @GetMapping("/products/{id}")
    Product product(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
    @PostMapping("/products")
    Product newProduct(@RequestBody Product newProd){
        return repository.save(newProd);
    }

    @PutMapping("/products/{id}")
    Product update(@RequestBody Product replaceProduct, @PathVariable Long id){
        return repository.findById(id).map(product -> {
            product.setName(replaceProduct.getName());
            product.setPrice(replaceProduct.getPrice());
            product.setMeasureUnit(replaceProduct.getMeasureUnit());
            return repository.save(product);
        }).orElseGet(()-> {replaceProduct.setId(id);
        return repository.save(replaceProduct);});
    }

    @DeleteMapping("/products/{id}")
    String message(@PathVariable Long id){
           repository.deleteById(id);
           return "Product deleted from the database";
    }
    @DeleteMapping("/products")
    String message(){
        repository.deleteAll();
        return "All products deleted";
    }
}
