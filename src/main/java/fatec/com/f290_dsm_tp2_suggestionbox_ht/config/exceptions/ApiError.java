package fatec.com.f290_dsm_tp2_suggestionbox_ht.config.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError {
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
