package fatec.com.f290_dsm_tp2_suggestionbox_ht.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fatec.com.f290_dsm_tp2_suggestionbox_ht.model.entities.Category;
import fatec.com.f290_dsm_tp2_suggestionbox_ht.repositories.CategoryRepository;

@Service
public class CategoryService {
    
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category salvar(Category category) {
        return repository.save(category);
    }

    public CategoryRepository getRepository(){
        return repository;
    }

    public List<Category> getAllCategories() {
        return repository.findAll();

    }

    public Category atualizar(Integer id, Category pCategory){
        Optional<Category> optCategory = repository.findById(id);

        if(optCategory.isPresent()){
            Category category = optCategory.get();
            category.setDescription(pCategory.getDescription());
            return repository.save(category);
        }
        throw new RuntimeException("Categoria não localizada. ID: " +id);
    }

    public void remover(Integer Id){
            repository.deleteById(Id);
        }

    public Category buscarPorId(Integer pId){
        Optional<Category> optional = repository.findById(pId);
        if(optional.isEmpty()){
            throw new RuntimeException("Categoria não localizada. ID: " + pId);
        }
        return optional.get();
    }
}

