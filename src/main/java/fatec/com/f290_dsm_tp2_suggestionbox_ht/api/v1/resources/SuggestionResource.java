package fatec.com.f290_dsm_tp2_suggestionbox_ht.api.v1.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fatec.com.f290_dsm_tp2_suggestionbox_ht.model.entities.Suggestion;
import fatec.com.f290_dsm_tp2_suggestionbox_ht.services.SuggestionService;

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

    @PutMapping("/{id}")
    public Suggestion update(@PathVariable("id")Integer pId, @RequestBody Suggestion suggestion){
        return service.atualizar(pId, suggestion);
    }

    @GetMapping("/{id}")
    public Suggestion findById(@PathVariable("id")Integer pId){
        return service.buscarPorId(pId);
    }

    @GetMapping("/all")
    public List<Suggestion>getAll(){
        return service.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer pId) throws Exception{
        service.remover(pId);
    }
    
}