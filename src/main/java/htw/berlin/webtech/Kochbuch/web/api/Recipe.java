package htw.berlin.webtech.Kochbuch.web.api;

import java.util.List;

public class Recipe {
    private long id;
    private String recipeName;

    private String description;

    private int duration;

    private List<Ingredient> Ingredients;

    public Recipe(long id, String recipeName, String description, int duration, List<Ingredient> Ingredients) {
        this.id = id;
        this.recipeName = recipeName;
        this.description = description;
        this.duration = duration;
        this.Ingredients = Ingredients;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getrecipeName() {
        return recipeName;
    }

    public void setrecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}
