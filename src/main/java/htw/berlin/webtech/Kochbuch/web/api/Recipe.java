package htw.berlin.webtech.Kochbuch.web.api;

import java.util.Set;

public class Recipe {
    Set<IngredientQuantity> ingredientquantities;
    private long id;
    private String recipeName;
    private String description;
    private int duration;

    public Recipe(long id, String recipeName, String description, int duration, Set<IngredientQuantity> ingredientquantities) {
        this.id = id;
        this.recipeName = recipeName;
        this.description = description;
        this.duration = duration;
        this.ingredientquantities = ingredientquantities;
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

    public Set<IngredientQuantity> getIngredientquantities() {
        return ingredientquantities;
    }

    public void setIngredientquantities(Set<IngredientQuantity> ingredientquantities) {
        this.ingredientquantities = ingredientquantities;
    }
}