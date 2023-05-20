package fatec.com.f290_dsm_tp2_suggestionbox_ht.api.v1.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fatec.com.f290_dsm_tp2_suggestionbox_ht.model.entities.Category;
import fatec.com.f290_dsm_tp2_suggestionbox_ht.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryResource {

    private final CategoryService service;

    public CategoryResource(CategoryService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<Void> save(@RequestBody Category category) {
        category.setId(null);
        service.salvar(category);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<Category> getAllCategories(){
        List<Category> categories = CategoryService.getAllCategories();
        return categories;
    }
}
