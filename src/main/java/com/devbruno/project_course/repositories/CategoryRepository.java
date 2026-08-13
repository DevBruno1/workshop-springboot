package com.devbruno.project_course.repositories;

import com.devbruno.project_course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
