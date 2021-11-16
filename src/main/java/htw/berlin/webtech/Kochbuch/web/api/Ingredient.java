package htw.berlin.webtech.Kochbuch.web.api;

import htw.berlin.webtech.Kochbuch.persistence.RecipeEntity;

import java.util.List;

public class Ingredient{
    private long ingredient_id;
    private String ingredientName;
    private int calories;
    private List <Recipe> recipes;

    public Ingredient(long ingredient_id, String ingredientName, int calories, List<Recipe> recipes) {
        this.ingredient_id = ingredient_id;
        this.ingredientName = ingredientName;
        this.calories = calories;
        this.recipes = recipes;
    }

    public long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(long ingredient_id) {
        this.ingredient_id = ingredient_id;
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