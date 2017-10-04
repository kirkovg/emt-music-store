package mk.ukim.finki.emt.musicstore.repository;

import mk.ukim.finki.emt.musicstore.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByParentIsNull();

    List<Category> findByParentId(Long categoryId);
}
