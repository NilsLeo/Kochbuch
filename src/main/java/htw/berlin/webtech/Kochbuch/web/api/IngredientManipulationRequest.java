package htw.berlin.webtech.Kochbuch.web.api;

import htw.berlin.webtech.Kochbuch.persistence.IngredientQuantityEntity;

import java.util.List;

public class IngredientManipulationRequest {
    List<IngredientQuantityEntity> ingredientquantities;
    private String ingredientName;
    private int calories;

    public IngredientManipulationRequest(List<IngredientQuantityEntity> ingredientquantities, String ingredientName, int calories) {
        this.ingredientquantities = ingredientquantities;
        this.ingredientName = ingredientName;
        this.calories = calories;
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

    public List<IngredientQuantityEntity> getIngredientquantities() {
        return ingredientquantities;
    }

    public void setIngredientquantities(List<IngredientQuantityEntity> ingredientquantities) {
        this.ingredientquantities = ingredientquantities;
    }
}
