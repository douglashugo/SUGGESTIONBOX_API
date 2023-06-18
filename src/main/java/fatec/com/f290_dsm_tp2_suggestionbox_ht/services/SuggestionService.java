package fatec.com.f290_dsm_tp2_suggestionbox_ht.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import fatec.com.f290_dsm_tp2_suggestionbox_ht.config.exceptions.ObjectNotFoundException;
import fatec.com.f290_dsm_tp2_suggestionbox_ht.model.entities.Suggestion;
import fatec.com.f290_dsm_tp2_suggestionbox_ht.repositories.SuggestionRepository;

@Service
public class SuggestionService {

    private SuggestionRepository suggestionRepository;

    public SuggestionService(SuggestionRepository suggestionRepository) {
        this.suggestionRepository = suggestionRepository;
    }

    public List<Suggestion> buscarTodos() {
        return suggestionRepository.findAll();
    }

    public Suggestion buscarPorId(Integer pId) {
        Optional<Suggestion> optional = suggestionRepository.findById(pId);
        if (optional.isEmpty()) {
            throw new ObjectNotFoundException("Categoria não localizada. ID: " + pId);
        }
        return optional.get();
    }

    public Suggestion atualizar(Integer id, Suggestion pSuggestion) {
        Optional<Suggestion> optSuggestion = suggestionRepository.findById(id);

        if (optSuggestion.isPresent()) {
            Suggestion suggestion = optSuggestion.get();
            suggestion.setDescription(pSuggestion.getDescription());
            return suggestionRepository.save(suggestion);
        }
        throw new ObjectNotFoundException("Categoria não localizada. ID: " + id);
    }

    public void remover(Integer id) throws Exception {
        //try {
            suggestionRepository.deleteById(id);
        //} catch (Exception e) {
        //    throw new ObjectNotFoundException("Categoria não localizada. ID: " + id);
        //}
    }

    public Suggestion create(@Valid Suggestion suggestion) {
        return suggestionRepository.save(suggestion);
    }

    public Suggestion salvar(Suggestion suggestion) {
    try {
        // Tente salvar a sugestão no repositório
        return suggestionRepository.save(suggestion);
    } catch (Exception e) {
        throw new IllegalArgumentException("Argumento inválido: " + e.getMessage());
    }
}



}

