package htw.berlin.webtech.Kochbuch.web.api;

import java.util.List;


public class Ingredient {
    List<IngredientQuantity> ingredientQuantities;
    private long ingredient_id;
    private String ingredientName;
    private int calories;

    public Ingredient(long ingredient_id, String ingredientName, int calories, List<IngredientQuantity> ingredientQuantities) {
        this.ingredient_id = ingredient_id;
        this.ingredientName = ingredientName;
        this.calories = calories;
        this.ingredientQuantities = ingredientQuantities;
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

    public List<IngredientQuantity> getIngredientQuantities() {
        return ingredientQuantities;
    }

    public void setIngredientQuantities(List<IngredientQuantity> ingredientQuantities) {
        this.ingredientQuantities = ingredientQuantities;
    }
}