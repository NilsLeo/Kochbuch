package htw.berlin.webtech.Kochbuch.service;

import htw.berlin.webtech.Kochbuch.persistence.IngredientRepository;
import htw.berlin.webtech.Kochbuch.persistence.RecipeEntity;
import htw.berlin.webtech.Kochbuch.persistence.RecipeRepository;
import htw.berlin.webtech.Kochbuch.web.api.Recipe;
import htw.berlin.webtech.Kochbuch.web.api.RecipeManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeTransformer recipeTransformer;
    private final IngredientRepository ingredientRepository;

    public RecipeService(RecipeRepository recipeRepository, RecipeTransformer recipeTransformer, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.recipeTransformer = recipeTransformer;
        this.ingredientRepository = ingredientRepository;
    }

    public List<Recipe> findAll() {
        List<RecipeEntity> Recipes = recipeRepository.findAll();
        return Recipes.stream()
                .map(recipeTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Recipe findById(Long id) {
        var RecipeEntity = recipeRepository.findById(id);
        return RecipeEntity.map(recipeTransformer::transformEntity).orElse(null);
    }

    public Recipe create(RecipeManipulationRequest request) {
        var recipeEntity = new RecipeEntity(request.getRecipeName(), request.getDescription(), request.getDuration());
        recipeEntity = recipeRepository.save(recipeEntity);
        return recipeTransformer.transformEntity(recipeEntity);
    }

    public Recipe update(Long id, RecipeManipulationRequest request) {
        var RecipeEntityOptional = recipeRepository.findById(id);
        if (RecipeEntityOptional.isEmpty()) {
            return null;
        }
        var recipeEntity = RecipeEntityOptional.get();
        recipeEntity.setRecipeName(request.getRecipeName());
        recipeEntity.setDescription(request.getDescription());
        recipeEntity.setDuration(request.getDuration());
        recipeEntity = recipeRepository.save(recipeEntity);
        return recipeTransformer.transformEntity(recipeEntity);
    }

    public boolean deleteById(Long id) {
        if (!recipeRepository.existsById(id)) {
            return false;
        }
        recipeRepository.deleteById(id);
        return true;
    }
}