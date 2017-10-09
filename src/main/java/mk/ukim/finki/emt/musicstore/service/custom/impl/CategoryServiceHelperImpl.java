package mk.ukim.finki.emt.musicstore.service.custom.impl;

import mk.ukim.finki.emt.musicstore.domain.Category;
import mk.ukim.finki.emt.musicstore.domain.exceptions.CategoryInUseException;
import mk.ukim.finki.emt.musicstore.domain.exceptions.EntityNotFoundException;
import mk.ukim.finki.emt.musicstore.repository.CategoryRepository;
import mk.ukim.finki.emt.musicstore.service.custom.CategoryServiceHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceHelperImpl implements CategoryServiceHelper {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceHelperImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createTopLevelCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public Category createCategory(String name, Long parentId) {
        Category category = new Category();
        category.setName(name);
        category.setParent(categoryRepository.findOne(parentId));
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategoryName(Long id, String newName) {
        Category category = categoryRepository.findOne(id);
        category.setName(newName);
        return categoryRepository.save(category);
    }

    @Override
    public Category changeCategoryParent(Long id, Long parentId) throws EntityNotFoundException {
        Category category = categoryRepository.findOne(id);
        Category parent = categoryRepository.findOne(parentId);
        if (parent == null) {
            throw new EntityNotFoundException();
        }
        category.setParent(parent);
        return categoryRepository.save(category);
    }

    @Override
    public void removeCategory(Long categoryId) throws CategoryInUseException {
        List<Category> children = categoryRepository.findByParentId(categoryId);
        if (children != null && !children.isEmpty()) {
            throw new CategoryInUseException();
        }
        categoryRepository.delete(categoryId);
    }

    @Override
    public List<Category> getTopLevelCategories() {
        return categoryRepository.findByParentIsNull();
    }

    @Override
    public List<Category> getSubCategories(Long categoryId) {
        return categoryRepository.findByParentId(categoryId);
    }
}
