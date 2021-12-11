package htw.berlin.webtech.Kochbuch.web.api;

import java.util.List;

public class RecipeManipulationRequest {
    private String recipeName;
    private String description;
    private int duration;
    private List<Long> ingredientIds;

    public RecipeManipulationRequest(String recipeName, String description, int duration, List<Long> ingredientIds) {
        this.recipeName = recipeName;
        this.description = description;
        this.duration = duration;
        this.ingredientIds = ingredientIds;
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

    public List<Long> getIngredientIds() {
        return ingredientIds;
    }

    public void setIngredientIds(List<Long> ingredientIds) {
        this.ingredientIds = ingredientIds;
    }
}

