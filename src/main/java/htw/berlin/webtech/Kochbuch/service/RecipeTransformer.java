package htw.berlin.webtech.Kochbuch.service;

import htw.berlin.webtech.Kochbuch.persistence.RecipeEntity;
import htw.berlin.webtech.Kochbuch.web.api.Recipe;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RecipeTransformer {
    private final IngredientTransformer ingredientTransformer;

    public RecipeTransformer(IngredientTransformer ingredientTransformer) {
        this.ingredientTransformer = ingredientTransformer;
    }

    public Recipe transformEntity(RecipeEntity recipeEntity) {
        var recipes = recipeEntity.getIngredients().stream().map(ingredientTransformer::transformEntity).collect(Collectors.toList());
        return new Recipe(
                recipeEntity.getId(),
                recipeEntity.getRecipeName(),
                recipeEntity.getDescription(),
                recipeEntity.getDuration(),
                recipes
        );
    }
}
