package com.devbruno.project_course.repositories;

import com.devbruno.project_course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
