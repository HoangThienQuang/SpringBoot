package Demo01.demov1.Repositories;

import Demo01.demov1.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepo extends JpaRepository<Product, Long> {
}
