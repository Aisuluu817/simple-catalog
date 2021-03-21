package restproject.demo.product;

import org.springframework.web.bind.annotation.*;
import restproject.demo.ProductNotFoundException;
import restproject.demo.ProductRepository;

@RestController
@RequestMapping(path="api/v1/products")
public class ProductController {
    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<Product> all() {
            return repository.findAll();
    }

    @GetMapping("/{id}")
    Product product(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
    @PostMapping
    Product newProduct(@RequestBody Product newProd){
        return repository.save(newProd);
    }

    @PutMapping("/{id}")
    Product update(@RequestBody Product replaceProduct, @PathVariable Long id){
        return repository.findById(id).map(product -> {
            product.setName(replaceProduct.getName());
            product.setPrice(replaceProduct.getPrice());
            product.setMeasureUnit(replaceProduct.getMeasureUnit());
            return repository.save(product);
        }).orElseGet(()-> {replaceProduct.setId(id);
        return repository.save(replaceProduct);});
    }

    @DeleteMapping("/{id}")
    String message(@PathVariable Long id){
           repository.deleteById(id);
           return "Product deleted from the database";
    }
    @DeleteMapping
    String message(){
        repository.deleteAll();
        return "All products deleted";
    }
}
