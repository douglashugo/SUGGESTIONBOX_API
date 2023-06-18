package fatec.com.f290_dsm_tp2_suggestionbox_ht.api.v1.resources;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fatec.com.f290_dsm_tp2_suggestionbox_ht.model.entities.Category;
import fatec.com.f290_dsm_tp2_suggestionbox_ht.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryResource {

    private final CategoryService service;

    public CategoryResource(CategoryService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Category> save(@RequestBody Category category) {
        category.setId(null);
        Category cat = service.salvar(category);

        ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cat.getId()).toUri();

        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable("id")Integer pId, @RequestBody Category category){
        return service.atualizar(pId, category);
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable("id")Integer pId){
        return service.buscarPorId(pId);
    }

    @GetMapping("/all")
    public List<Category>getAll(){
        return service.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer pId) throws Exception {
        service.remover(pId);
    }

}
