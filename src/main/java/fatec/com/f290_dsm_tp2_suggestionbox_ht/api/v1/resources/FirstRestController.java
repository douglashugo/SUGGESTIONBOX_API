package fatec.com.f290_dsm_tp2_suggestionbox_ht.api.v1.resources;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fatec.com.f290_dsm_tp2_suggestionbox_ht.model.Suggestion;

@RestController 
@RequestMapping("/") 
public class FirstRestController {

    @GetMapping
    public ResponseEntity<?> helloApiGet() {
        System.out.println("GET: Passou pelo FirstRestController!");
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> helloApiPost(@RequestBody Suggestion suggestion) {
        System.out.println("POST: Passou pelo FirstRestController!");
        System.out.println("Body: " + suggestion);
        return ResponseEntity.created(null).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> helloApiDelete(@PathVariable("id") Integer id) {
        System.out.println("DELETE: Passou pelo FirstRestController!");
        System.out.println("Recebido ID: " + id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> helloApiPut(@PathVariable("id") Integer id,
            @RequestBody Suggestion suggestion) {
        System.out.println("PUT: Passou pelo FirstRestController!");
        System.out.println("Recebido ID: " + id);
        System.out.println("Body: " + suggestion);

        if (suggestion.getId().equals(100)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Suggestion>> getAll() {
        List<Suggestion> all = Arrays.asList(
                new Suggestion(1, "Primeira sugestao",
                        LocalDate.of(2019, 3, 12)),
                new Suggestion(2, "Segunda sugestao",
                        LocalDate.of(2020, 1, 2)),
                new Suggestion(3, "Terceira sugestao",
                        LocalDate.of(2021, 9, 19)),
                new Suggestion(4, "Quarta sugestao",
                        LocalDate.of(2017, 12, 30)),
                new Suggestion(5, "Quinta sugestao",
                        LocalDate.of(2016, 4, 16))
        );

        return ResponseEntity.ok().body(all);
    }
    
}

