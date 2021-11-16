package htw.berlin.webtech.Kochbuch.web.api;

import java.util.ArrayList;
import java.util.List;

public class RecipeManipulationRequest {
    private String recipeName;
    private String description;
    private int duration;
    private List<Ingredient> Ingredients;

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

    public List<Ingredient> getIngredients() {
        return Ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        Ingredients = ingredients;
    }
}
