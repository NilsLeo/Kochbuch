package htw.berlin.webtech.Kochbuch.web.api;

import htw.berlin.webtech.Kochbuch.persistence.IngredientQuantityEntity;

import java.util.List;

public class RecipeManipulationRequest {
    List<IngredientQuantityEntity> ingredientQuantities;
    private String recipeName;
    private String description;
    private int duration;

    public RecipeManipulationRequest(List<IngredientQuantityEntity> ingredientQuantities, String recipeName, String description, int duration) {
        this.ingredientQuantities = ingredientQuantities;
        this.recipeName = recipeName;
        this.description = description;
        this.duration = duration;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<IngredientQuantityEntity> getIngredientQuantities() {
        return ingredientQuantities;
    }

    public void setIngredientQuantities(List<IngredientQuantityEntity> ingredientQuantities) {
        this.ingredientQuantities = ingredientQuantities;
    }
}

