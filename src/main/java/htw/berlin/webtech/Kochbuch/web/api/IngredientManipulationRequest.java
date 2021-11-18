package htw.berlin.webtech.Kochbuch.web.api;

import htw.berlin.webtech.Kochbuch.persistence.IngredientQuantity;

import java.util.Set;

public class IngredientManipulationRequest {
    Set<IngredientQuantity> ingredientquantities;
    private String ingredientName;
    private int calories;

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

    public Set<IngredientQuantity> getIngredientquantities() {
        return ingredientquantities;
    }

    public void setIngredientquantities(Set<IngredientQuantity> ingredientquantities) {
        this.ingredientquantities = ingredientquantities;
    }
}
