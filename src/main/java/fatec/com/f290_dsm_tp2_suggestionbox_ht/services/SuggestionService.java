package fatec.com.f290_dsm_tp2_suggestionbox_ht.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.com.f290_dsm_tp2_suggestionbox_ht.config.exceptions.ObjectNotFoundException;
import fatec.com.f290_dsm_tp2_suggestionbox_ht.model.entities.Category;
import fatec.com.f290_dsm_tp2_suggestionbox_ht.model.entities.Suggestion;
import fatec.com.f290_dsm_tp2_suggestionbox_ht.repositories.SuggestionRepository;
import fatec.com.f290_dsm_tp2_suggestionbox_ht.repositories.CategoryRepository;


@Service
public class SuggestionService {

    @Autowired
    private SuggestionRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

     public void seedCategories() {
        Category sugestao = categoryRepository.save(new Category("Sugestão"));
        Category critica = categoryRepository.save(new Category("Crítica"));
        Category elogio = categoryRepository.save(new Category("Elogio"));
        Category comentario = categoryRepository.save(new Category("Comentário"));

        // Criação do registro com base em uma categoria
        Suggestion suggestion = new Suggestion();
        suggestion.setTitle("Título do registro base");
        suggestion.setDescription("Descrição do registro base");
        suggestion.setCategory(sugestao); // Defina a categoria desejada aqui
        repository.save(suggestion);
    }

    // Criar validação exceção para ExceptionHandler
    public Suggestion create(Suggestion suggestion) {
        if (suggestion == null) {
            throw new ObjectNotFoundException("Sugestão não pode ser nula.");
        }
        return repository.save(suggestion);

    }

    // Criar método que retorne todas as sugestões do banco de dados.
    public List<Suggestion> getAll() {
        return repository.findAll();
    }

    // Criar método que remova uma sugestão do banco de dados.
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ObjectNotFoundException("Sugestão não encontrada com o ID: " + id);
        }
        repository.deleteById(id);
    }

    // Criar método que retorne uma sugestão com base num id.
    public Suggestion getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Sugestão não encontrada com o ID: " + id));
    }

}
