package restproject.demo;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Could find product with id = " + id);
    }
}
