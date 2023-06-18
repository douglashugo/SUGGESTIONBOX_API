package fatec.com.f290_dsm_tp2_suggestionbox_ht.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import fatec.com.f290_dsm_tp2_suggestionbox_ht.model.entities.Category;
import fatec.com.f290_dsm_tp2_suggestionbox_ht.model.entities.Suggestion;

public interface SuggestionRepository extends JpaRepository<Suggestion, Integer>{

    Category save(Category category);
    // Não é necessário implementar os métodos aqui,
    // pois eles são herdados da interface JpaRepository.
 
}