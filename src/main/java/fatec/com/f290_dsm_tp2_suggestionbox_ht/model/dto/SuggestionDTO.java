package fatec.com.f290_dsm_tp2_suggestionbox_ht.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import fatec.com.f290_dsm_tp2_suggestionbox_ht.model.entities.Category;


public class SuggestionDTO {

    private Integer id;

    @NotBlank
    private String description;
    private LocalDate data;

    private Category category;
}