package pl.lickerish.cashregistryspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lickerish.cashregistryspring.DTO.ProductDTO;
import pl.lickerish.cashregistryspring.model.Product;
import pl.lickerish.cashregistryspring.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(ProductDTO product) {
        return productRepository.save(new Product(product.getId(), product.getProductName(), product.getProductNumber(), product.getPrice()));
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public Product update(ProductDTO newProduct, Integer id) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setProductNumber(newProduct.getProductNumber());
                    product.setPrice(newProduct.getPrice());
                    product.setProductName(newProduct.getProductName());
                    return productRepository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return productRepository.save(new Product(newProduct.getId(), newProduct.getProductName(), newProduct.getProductNumber(), newProduct.getPrice()));
                });
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
