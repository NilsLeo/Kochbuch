package htw.berlin.webtech.Kochbuch.web.api;

import java.util.List;

public class IngredientManipulationRequest {
    private String ingredientName;
    private int calories;
    private List <Recipe> recipes;

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

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
