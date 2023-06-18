package fatec.com.f290_dsm_tp2_suggestionbox_ht.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Suggestion {
    private Integer id;
    private String description;
    private LocalDate data;
}