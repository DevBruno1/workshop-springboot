package com.devbruno.project_course.repositories;

import com.devbruno.project_course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
