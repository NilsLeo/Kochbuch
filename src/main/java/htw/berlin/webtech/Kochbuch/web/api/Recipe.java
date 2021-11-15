package htw.berlin.webtech.Kochbuch.web.api;

import java.util.List;

public class Recipe {
    private long id;
    private String recipeName;

    public Recipe(long id, String recipeName) {
        this.id = id;
        this.recipeName = recipeName;

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
