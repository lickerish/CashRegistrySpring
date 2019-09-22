package pl.lickerish.cashregistryspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.lickerish.cashregistryspring.DTO.ProductDTO;
import pl.lickerish.cashregistryspring.model.Product;
import pl.lickerish.cashregistryspring.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/create")
    public ProductDTO create(@RequestParam String productName, @RequestParam String productNumber, @RequestParam Double price) {
        ProductDTO productDTO = ProductDTO.builder()
                .productName(productName)
                .productNumber(productNumber)
                .price(price)
                .build();
        productService.create(productDTO);
        return productDTO;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/createWithJSON")
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        productService.create(productDTO);
        return productDTO;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/massCreate")
    public List<ProductDTO> create(@RequestBody List<ProductDTO> products) {
        products.forEach(product -> productService.create(product));
        return products;
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/findById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Product> findById(@PathVariable Integer id) {
        return productService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping(value = "/update/{id}")
    public Product update(@RequestBody ProductDTO productDTO, @PathVariable Integer id) {
        return productService.update(productDTO, id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping(value = "/update")
    public Product update(@RequestBody ProductDTO productDTO) {
        return productService.update(productDTO, productDTO.getId());
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        productService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete")
    public void delete(@RequestBody List<Integer> ids) {
        ids.forEach(id -> productService.deleteById(id));

    }

}
