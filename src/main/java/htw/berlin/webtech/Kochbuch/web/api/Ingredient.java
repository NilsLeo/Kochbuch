package htw.berlin.webtech.Kochbuch.web.api;

import htw.berlin.webtech.Kochbuch.persistence.IngredientQuantity;

import java.util.List;
import java.util.Set;

public class Ingredient {
    private long ingredient_id;
    private String ingredientName;
    private int calories;
    Set<IngredientQuantity> ingredientquantities;

    public Ingredient(long ingredient_id, String ingredientName, int calories, Set<IngredientQuantity> ingredientquantities) {
        this.ingredient_id = ingredient_id;
        this.ingredientName = ingredientName;
        this.calories = calories;
        this.ingredientquantities = ingredientquantities;
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

    public Set<IngredientQuantity> getIngredientquantities() {
        return ingredientquantities;
    }

    public void setIngredientquantities(Set<IngredientQuantity> ingredientquantities) {
        this.ingredientquantities = ingredientquantities;
    }
}