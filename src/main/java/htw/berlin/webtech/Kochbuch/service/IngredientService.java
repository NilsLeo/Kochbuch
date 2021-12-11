package htw.berlin.webtech.Kochbuch.service;

import htw.berlin.webtech.Kochbuch.persistence.IngredientEntity;
import htw.berlin.webtech.Kochbuch.persistence.IngredientRepository;
import htw.berlin.webtech.Kochbuch.persistence.RecipeRepository;
import htw.berlin.webtech.Kochbuch.persistence.Unit;
import htw.berlin.webtech.Kochbuch.web.api.Ingredient;
import htw.berlin.webtech.Kochbuch.web.api.IngredientManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;
    private final RecipeTransformer recipeTransformer;
    private final IngredientTransformer ingredientTransformer;

    public IngredientService(IngredientRepository ingredientRepository, RecipeRepository recipeRepository, RecipeTransformer recipeTransformer, IngredientTransformer ingredientTransformer) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
        this.recipeTransformer = recipeTransformer;
        this.ingredientTransformer = ingredientTransformer;
    }

    public List<Ingredient> findAll() {
        List<IngredientEntity> Ingredients = ingredientRepository.findAll();
        return Ingredients.stream()
                .map(ingredientTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Ingredient findById(Long id) {
        var ingredientEntity = ingredientRepository.findById(id);
        return ingredientEntity.map(ingredientTransformer::transformEntity).orElse(null);
    }

    public Ingredient create(IngredientManipulationRequest request) {
        var unit = Unit.valueOf(request.getUnit());
        var recipe = recipeRepository.findById(request.getRecipeId()).orElseThrow();
        var ingredientEntity = new IngredientEntity(request.getIngredientName(), request.getAmount(), unit, recipe);
        ingredientEntity = ingredientRepository.save(ingredientEntity);
        return ingredientTransformer.transformEntity(ingredientEntity);
    }

    public Ingredient update(Long id, IngredientManipulationRequest request) {
        var ingredientEntityOptional = ingredientRepository.findById(id);
        if (ingredientEntityOptional.isEmpty()) {
            return null;
        }
        var ingredientEntity = ingredientEntityOptional.get();
        ingredientEntity.setIngredientName(request.getIngredientName());
        ingredientEntity.setAmount(request.getAmount());
        ingredientEntity.setUnit(Unit.valueOf(request.getUnit()));
        ingredientEntity = ingredientRepository.save(ingredientEntity);

        return ingredientTransformer.transformEntity(ingredientEntity);
    }

    public boolean deleteById(Long id) {
        if (!ingredientRepository.existsById(id)) {
            return false;
        }
        ingredientRepository.deleteById(id);
        return true;
    }
}