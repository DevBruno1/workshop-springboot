package com.devbruno.project_course.repositories;

import com.devbruno.project_course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
