package Demo01.demov1.Controller;

import Demo01.demov1.Models.Product;
import Demo01.demov1.Models.responseObject;
import Demo01.demov1.Repositories.productRepo;
import Demo01.demov1.data.database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Products")
public class productController {
    private static final Logger logger = LoggerFactory.getLogger(productController.class);

    @Autowired
    private productRepo repository;

    //Get all product -----------------------------------------------------------------------------------
    @GetMapping("")
    //
    List<Product> getAllProducts()
    {
        return  repository.findAll();
    }

    // Get product by id --------------------------------------------------------------------------------
    @GetMapping("/{id}")
    ResponseEntity<responseObject> findById (@PathVariable Long id)
    {
        Optional<Product> foundProduct = repository.findById(id);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new responseObject("ok","Query successful", foundProduct)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new responseObject("false","Can not found product with id: " + id, "")
                );
    }

    // Add new product --- --------------------------------------------------------------------------------
    @PostMapping("/insert")
    ResponseEntity<responseObject> insertProduct(@RequestBody Product newproduct)
    {
        List<Product> foundProduct = repository.findByProductName(newproduct.getProductName().trim());
        return !foundProduct.isEmpty() ?
            ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new responseObject("Fail", "Product already exit", "")
            ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new responseObject("ok", "Insert successful", repository.save(newproduct))
                );
    }

    // upsert - Update existed product if product doesn't exist then insert new
    @PutMapping("/{id}")
    ResponseEntity<responseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Long id)
    {
        Product updateProduct = repository.findById(id)
                .map(product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setPrice(newProduct.getPrice());
                    product.setDevyear(newProduct.getDevyear());
                    product.setUrl(newProduct.getUrl());
                    return repository.save(product);
                }).orElseGet(()->
                {
                    return repository.save(newProduct);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new responseObject("ok", "Update successful", updateProduct)
        );
    }
}
