package fatec.com.f290_dsm_tp2_suggestionbox_ht.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fatec.com.f290_dsm_tp2_suggestionbox_ht.config.exceptions.ObjectNotFoundException;
import fatec.com.f290_dsm_tp2_suggestionbox_ht.model.entities.Category;
import fatec.com.f290_dsm_tp2_suggestionbox_ht.repositories.CategoryRepository;


@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category salvar(Category category) {
        return repository.save(category);
    }

    public List<Category> buscarTodos() {
        return repository.findAll();
    }

    public Category atualizar(Integer id, Category pCategory) {
        Optional<Category> optCategory = repository.findById(id);

        if (optCategory.isPresent()) {
            Category category = optCategory.get();
            category.setDescription(pCategory.getDescription());
            return repository.save(category);
        }
        throw new ObjectNotFoundException("Categoria não localizada. ID: " + id);
    }

    public void remover(Integer id) throws Exception {
        //try{
            repository.deleteById(id);
        //}catch (Exception e){
        //    throw new ObjectNotFoundException("Categoria não localizada. ID: " +id);
        //}
    }

    public Category buscarPorId(Integer pId) {
        Optional<Category> optional = repository.findById(pId);
        if (optional.isEmpty()) {
            throw new ObjectNotFoundException("Categoria não localizada. ID: " +pId);
        }
        return optional.get();
    }
}
