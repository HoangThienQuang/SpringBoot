package Demo01.demov1.Repositories;

import Demo01.demov1.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface productRepo extends JpaRepository<Product, Long> {
    List<Product> findByProductName(String productName);
}
