package fatec.com.f290_dsm_tp2_suggestionbox_ht.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fatec.com.f290_dsm_tp2_suggestionbox_ht.model.entities.Category;
import fatec.com.f290_dsm_tp2_suggestionbox_ht.repositories.CategoryRepository;

@Service
public class CategoryService {
    
    private static CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        CategoryService.repository = repository;
    }

    public void salvar(Category category) {
        repository.save(category);
    }

    public CategoryRepository getRepository(){
        return repository;
    }

    public static List<Category> getAllCategories() {
        return repository.findAll();

    }



}