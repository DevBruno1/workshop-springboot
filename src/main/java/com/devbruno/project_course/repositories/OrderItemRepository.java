package com.devbruno.project_course.repositories;

import com.devbruno.project_course.entities.OrderItem;
import com.devbruno.project_course.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
