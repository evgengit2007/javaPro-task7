package ru.vtb.javaPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vtb.javaPro.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByUser(Long id);

    Optional<Product> findById(Long id);

}
