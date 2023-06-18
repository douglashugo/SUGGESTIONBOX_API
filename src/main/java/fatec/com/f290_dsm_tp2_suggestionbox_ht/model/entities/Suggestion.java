package fatec.com.f290_dsm_tp2_suggestionbox_ht.model.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "suggestions")
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 500)
    @NotBlank(message = "Descrição é obrigatória")
    private String description;
    private LocalDate data;

    @NotNull(message = "Categoria é obrigatória")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public void setTitle(String string) {
    }
}