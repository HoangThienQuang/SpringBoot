package Demo01.demov1.Controller;

import Demo01.demov1.Models.Product;
import Demo01.demov1.Repositories.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Products")
public class productController {

    @Autowired
    private productRepo repository;

    @GetMapping("")
    //
    List<Product> getAllProducts()
    {
        return  List.of(
                new Product(1L, "Mac01", 2020.0, 2004, ""),
                new Product(2L, "Mac02", 200.0, 2000, "")
        );
    }
}
