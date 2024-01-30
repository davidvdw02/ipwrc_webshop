package nl.david.ipwrc_webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.david.ipwrc_webshop.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
