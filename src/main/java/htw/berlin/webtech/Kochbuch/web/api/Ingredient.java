package htw.berlin.webtech.Kochbuch.web.api;

import htw.berlin.webtech.Kochbuch.persistence.IngredientQuantityEntity;

import java.util.Set;

public class Ingredient {
    Set<IngredientQuantityEntity> ingredientquantities;
    private long ingredient_id;
    private String ingredientName;
    private int calories;

    public Ingredient(long ingredient_id, String ingredientName, int calories, Set<IngredientQuantityEntity> ingredientquantities) {
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

    public Set<IngredientQuantityEntity> getIngredientquantities() {
        return ingredientquantities;
    }

    public void setIngredientquantities(Set<IngredientQuantityEntity> ingredientquantities) {
        this.ingredientquantities = ingredientquantities;
    }
}