package htw.berlin.webtech.Kochbuch.web.api;

import htw.berlin.webtech.Kochbuch.persistence.IngredientEntity;

import java.util.List;

public class Recipe {
    private long id;
    private String recipeName;

    private String description;

    private int duration;

    private List<Ingredient> ingredients;

    public Recipe(long id, String recipeName, String description, int duration, List<Ingredient> ingredients) {
        this.id = id;
        this.recipeName = recipeName;
        this.description = description;
        this.duration = duration;
        this.ingredients = ingredients;

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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}