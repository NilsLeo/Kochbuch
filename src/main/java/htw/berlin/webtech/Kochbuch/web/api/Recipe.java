package htw.berlin.webtech.Kochbuch.web.api;

import java.util.List;

public class Recipe {
    List<IngredientQuantity> ingredientQuantities;
    private long id;
    private String recipeName;
    private String description;
    private int duration;

    public Recipe(long id, String recipeName, String description, int duration, List<IngredientQuantity> ingredientQuantities) {
        this.id = id;
        this.recipeName = recipeName;
        this.description = description;
        this.duration = duration;
        this.ingredientQuantities = ingredientQuantities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<IngredientQuantity> getIngredientQuantities() {
        return ingredientQuantities;
    }

    public void setIngredientQuantities(List<IngredientQuantity> ingredientQuantities) {
        this.ingredientQuantities = ingredientQuantities;
    }
}