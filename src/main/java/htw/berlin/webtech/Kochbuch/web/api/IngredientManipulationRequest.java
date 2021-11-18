package htw.berlin.webtech.Kochbuch.web.api;

import htw.berlin.webtech.Kochbuch.persistence.IngredientQuantity;
import htw.berlin.webtech.Kochbuch.persistence.RecipeEntity;

import java.util.List;
import java.util.Set;

public class IngredientManipulationRequest {
    private String ingredientName;
    private int calories;
    Set<IngredientQuantity> ingredientquantities;

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
