package htw.berlin.webtech.Kochbuch.web.api;

import htw.berlin.webtech.Kochbuch.persistence.RecipeEntity;

import java.util.List;

public class IngredientManipulationRequest {
    private String ingredientName;
    private int calories;
    private List <RecipeEntity> recipeEntities;

    public IngredientManipulationRequest(String IngredientName) {
        this.ingredientName = IngredientName;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }


    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }


    public void setRecipes(List<RecipeEntity> recipeEntities) {
        this.recipeEntities = recipeEntities;
    }

    public List<RecipeEntity> getRecipeEntities() {
        return recipeEntities;
    }
}
