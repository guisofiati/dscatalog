package github.guisofiati.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github.guisofiati.catalog.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
}