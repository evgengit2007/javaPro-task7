package ru.vtb.javaPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtb.javaPro.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<List<Product>> findByUser(Long id);

    Optional<Product> findById(Long id);

    Optional<Product> findByIdAndUser(Long pid, Long uid);

}
