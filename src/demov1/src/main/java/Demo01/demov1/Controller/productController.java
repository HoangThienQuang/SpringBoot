package Demo01.demov1.Controller;

import Demo01.demov1.Models.Product;
import Demo01.demov1.Models.responseObject;
import Demo01.demov1.Repositories.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Products")
public class productController {

    @Autowired
    private productRepo repository;

    @GetMapping("")
    //
    List<Product> getAllProducts()
    {
        return  repository.findAll();
    }

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
}
