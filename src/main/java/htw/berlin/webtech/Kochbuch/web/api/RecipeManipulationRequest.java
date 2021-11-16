package htw.berlin.webtech.Kochbuch.web.api;

import htw.berlin.webtech.Kochbuch.persistence.IngredientEntity;

import java.util.ArrayList;
import java.util.List;

public class RecipeManipulationRequest {
    private String recipeName;
    private String description;
    private int duration;
    private List<IngredientEntity> ingredientEntities;

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

    public List<IngredientEntity> getIngredientEntities() {
        return ingredientEntities;
    }

    public void setIngredientEntities(List<IngredientEntity> ingredientEntities) {
        this.ingredientEntities = ingredientEntities;
    }
}

