package mk.ukim.finki.emt.musicstore.service.custom;


import mk.ukim.finki.emt.musicstore.domain.Category;
import mk.ukim.finki.emt.musicstore.domain.exceptions.CategoryInUseException;
import mk.ukim.finki.emt.musicstore.domain.exceptions.EntityNotFoundException;

import java.util.List;

public interface CategoryServiceHelper {

    Category createTopLevelCategory(String name);

    Category createCategory(String name, Long parentId);

    Category updateCategoryName(Long id, String newName);

    Category changeCategoryParent(Long id, Long parentId) throws EntityNotFoundException;

    void removeCategory(Long categoryId) throws CategoryInUseException;

    List<Category> getTopLevelCategories();

    List<Category> getSubCategories(Long categoryId);
}
