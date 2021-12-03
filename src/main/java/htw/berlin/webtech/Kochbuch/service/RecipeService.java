package htw.berlin.webtech.Kochbuch.service;

import htw.berlin.webtech.Kochbuch.persistence.IngredientQuantityEntity;
import htw.berlin.webtech.Kochbuch.persistence.RecipeEntity;
import htw.berlin.webtech.Kochbuch.persistence.RecipeRepository;
import htw.berlin.webtech.Kochbuch.web.api.IngredientQuantity;
import htw.berlin.webtech.Kochbuch.web.api.Recipe;
import htw.berlin.webtech.Kochbuch.web.api.RecipeManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> findAll() {
        List<RecipeEntity> Recipes = recipeRepository.findAll();
        return Recipes.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Recipe findById(Long id) {
        var RecipeEntity = recipeRepository.findById(id);
        return RecipeEntity.map(this::transformEntity).orElse(null);
    }

    public Recipe create(RecipeManipulationRequest request) {
        var RecipeEntity = new RecipeEntity(request.getRecipeName(), request.getDescription(), request.getDuration(), request.getIngredientQuantities());
        RecipeEntity = recipeRepository.save(RecipeEntity);
        return transformEntity(RecipeEntity);
    }

    public Recipe update(Long id, RecipeManipulationRequest request) {
        var RecipeEntityOptional = recipeRepository.findById(id);
        if (RecipeEntityOptional.isEmpty()) {
            return null;
        }
        var RecipeEntity = RecipeEntityOptional.get();
        RecipeEntity.setRecipeName(request.getRecipeName());
        RecipeEntity.setDescription(request.getDescription());
        RecipeEntity.setDuration(request.getDuration());
        RecipeEntity.setIngredientQuantities(request.getIngredientQuantities());
        RecipeEntity = recipeRepository.save(RecipeEntity);
        return transformEntity(RecipeEntity);
    }

    public IngredientQuantity transformIngredientQuantityEntity(IngredientQuantityEntity IngredientQuantityEntity) {
        return new IngredientQuantity(
                IngredientQuantityEntity.getRecipe().getId(),
                IngredientQuantityEntity.getIngredient().getId(),
                IngredientQuantityEntity.getQuantity(),
                IngredientQuantityEntity.getUnit()
        );
    }

    private Recipe transformEntity(RecipeEntity recipeEntity) {

        return new Recipe(
                recipeEntity.getId(),
                recipeEntity.getRecipeName(),
                recipeEntity.getDescription(),
                recipeEntity.getDuration(),
                recipeEntity.getIngredientQuantities().stream().map(this::transformIngredientQuantityEntity).collect(Collectors.toList())
        );
    }

    public boolean deleteById(Long id) {
        if (!recipeRepository.existsById(id)) {
            return false;
        }
        recipeRepository.deleteById(id);
        return true;
    }
}