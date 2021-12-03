package htw.berlin.webtech.Kochbuch.web;

import htw.berlin.webtech.Kochbuch.service.IngredientQuantityService;
import htw.berlin.webtech.Kochbuch.web.api.IngredientQuantity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientQuantityRestController {
    private IngredientQuantityService ingredientQuantityService;

    public IngredientQuantityRestController(IngredientQuantityService ingredientQuantityService) {
        this.ingredientQuantityService = ingredientQuantityService;
    }

    @GetMapping(path = "/api/v1/IngredientQuantities")
    public ResponseEntity<List<IngredientQuantity>> fetchIngredientQuantity() {
        return ResponseEntity.ok(ingredientQuantityService.findAll());
    }


    @GetMapping(path = "/api/v1/IngredientQuantities/{id}")
    public ResponseEntity<List<IngredientQuantity>> fetchIngredientsByRecipeId(@PathVariable Long id) {
        var IngredientQuantity = ingredientQuantityService.findByRecipeid(id);
        return IngredientQuantity != null ? ResponseEntity.ok(IngredientQuantity) : ResponseEntity.notFound().build();
    }
/*
    @PostMapping(path = "/api/v1/IngredientQuantities")
    public ResponseEntity<Void> createIngredient(@RequestBody IngredientManipulationRequest request) throws URISyntaxException {
        var Ingredient = IngredientService.create(request);
        URI uri = new URI("/api/v1/IngredientQuantities/" + Ingredient.getIngredient_id());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/IngredientQuantities/{id}")
    public ResponseEntity<IngredientQuantity> updateIngredientQuantity(@PathVariable Long id, @RequestBody IngredientManipulationRequest request) {
        var Ingredient = IngredientService.update(id, request);
        return Ingredient != null ? ResponseEntity.ok(Ingredient) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/IngredientQuantities/{id1}{id2}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id1,@PathVariable Long id2) {
        boolean successful = IngredientService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
*/
}

