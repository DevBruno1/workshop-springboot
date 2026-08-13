package com.devbruno.project_course.config;

import com.devbruno.project_course.entities.Category;
import com.devbruno.project_course.entities.Order;
import com.devbruno.project_course.entities.Product;
import com.devbruno.project_course.entities.User;
import com.devbruno.project_course.entities.enums.OrderStatus;
import com.devbruno.project_course.repositories.CategoryRepository;
import com.devbruno.project_course.repositories.OrderRepository;
import com.devbruno.project_course.repositories.ProductRepository;
import com.devbruno.project_course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired //Injection dependency
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.SHIPPED);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.DELIVERED);

        Category category = new Category(null, "Electronics");
        Category category1 = new Category(null, "Books");
        Category category2 = new Category(null, "Computers");

        Product product = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product product1 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product product2 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product product3 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product product4 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(category, category1, category2));
        productRepository.saveAll(Arrays.asList(product, product1, product2, product3, product4));

        product.getCategories().add(category1);
        product1.getCategories().add(category);
        product1.getCategories().add(category2);
        product2.getCategories().add(category2);
        product2.getCategories().add(category);
        product3.getCategories().add(category2);
        product3.getCategories().add(category);
        product4.getCategories().add(category1);

        productRepository.saveAll(Arrays.asList(product, product1, product2, product3, product4));
    }
}
