package fatec.com.f290_dsm_tp2_suggestionbox_ht.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity(name = "categories")
public class Category {

    public Category(String string) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Descrição é obrigatória")
    @Column(nullable = false, length = 100, unique = true)
    private String description;

    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private List<Suggestion> suggestions = new ArrayList<>();
}