package htw.berlin.webtech.Kochbuch.web;

import htw.berlin.webtech.Kochbuch.service.IngredientService;
import htw.berlin.webtech.Kochbuch.web.api.Ingredient;
import htw.berlin.webtech.Kochbuch.web.api.IngredientManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class IngredientRestController {
    private final IngredientService ingredientService;

    public IngredientRestController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping(path = "/api/v1/Ingredients")
    public ResponseEntity<List<Ingredient>> fetchIngredients() {
        return ResponseEntity.ok(ingredientService.findAll());
    }

    //wichtig das die long variable wie /{id} heißt da Spring das so automatisch erkennt
    @GetMapping(path = "/api/v1/Ingredients/{id}")
    public ResponseEntity<Ingredient> fetchIngredientById(@PathVariable Long id) {
        var ingredient = ingredientService.findById(id);
        return ingredient != null ? ResponseEntity.ok(ingredient) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/Ingredients")
    public ResponseEntity<Void> createIngredient(@RequestBody IngredientManipulationRequest request) throws URISyntaxException {
        var ingredient = ingredientService.create(request);
        URI uri = new URI("/api/v1/Ingredients/" + ingredient.getIngredient_id());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/Ingredients/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id, @RequestBody IngredientManipulationRequest request) {
        var ingredient = ingredientService.update(id, request);
        return ingredient != null ? ResponseEntity.ok(ingredient) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/Ingredients/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        boolean successful = ingredientService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}