package fatec.com.f290_dsm_tp2_suggestionbox_ht.api.v1.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fatec.com.f290_dsm_tp2_suggestionbox_ht.model.entities.Suggestion;
import fatec.com.f290_dsm_tp2_suggestionbox_ht.services.SuggestionService;


//TODO: Configurar RestController para o recurso /suggestion
@RestController
@RequestMapping("/suggestion")
public class SuggestionResource {

    @Autowired
    private SuggestionService service;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Suggestion suggestion) {

        Suggestion register = service.create(suggestion);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(register.getId())
                .toUri();

        return ResponseEntity.created(uri).build();

    }

    @GetMapping("/all")
    public List<Suggestion> getAll() {
        return service.getAll();
    }
}