package ru.practicum.ewm.main.server.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.main.server.category.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
