package fatec.com.f290_dsm_tp2_suggestionbox_ht.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fatec.com.f290_dsm_tp2_suggestionbox_ht.model.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}