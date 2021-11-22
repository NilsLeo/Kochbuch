package htw.berlin.webtech.Kochbuch.web.api;

import htw.berlin.webtech.Kochbuch.persistence.IngredientQuantityEntity;

import java.util.Set;

public class RecipeManipulationRequest {
    Set<IngredientQuantityEntity> ingredientQuantities;
    private String recipeName;
    private String description;
    private int duration;

    public RecipeManipulationRequest(String recipeName) {
        this.recipeName = recipeName;
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

    public Set<IngredientQuantityEntity> getIngredientQuantities() {
        return ingredientQuantities;
    }

    public void setIngredientQuantities(Set<IngredientQuantityEntity> ingredientQuantities) {
        this.ingredientQuantities = ingredientQuantities;
    }
}

