package htw.berlin.webtech.Kochbuch.web;

import htw.berlin.webtech.Kochbuch.service.RecipeService;
import htw.berlin.webtech.Kochbuch.web.api.Recipe;
import htw.berlin.webtech.Kochbuch.web.api.RecipeManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RecipeRestController {
    private final RecipeService RecipeService;

    public RecipeRestController(RecipeService RecipeService) {
        this.RecipeService = RecipeService;
    }

    @GetMapping(path = "/api/v1/Recipes")
    public ResponseEntity<List<Recipe>> fetchRecipes() {
        return ResponseEntity.ok(RecipeService.findAll());
    }

    //wichtig das die long variable wie /{id} heißt da Spring das so automatisch erkennt
    @GetMapping(path = "/api/v1/Recipes/{id}")
    public ResponseEntity<Recipe> fetchRecipeById(@PathVariable Long id) {
        var Recipe = RecipeService.findById(id);
        return Recipe != null ? ResponseEntity.ok(Recipe) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/Recipes")
    public ResponseEntity<Void> createRecipe(@RequestBody RecipeManipulationRequest request) throws URISyntaxException {
        var Recipe = RecipeService.create(request);
        URI uri = new URI("/api/v1/Recipes/" + Recipe.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/Recipes/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody RecipeManipulationRequest request) {
        var Recipe = RecipeService.update(id, request);
        return Recipe != null ? ResponseEntity.ok(Recipe) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/Recipes/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        boolean successful = RecipeService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}


