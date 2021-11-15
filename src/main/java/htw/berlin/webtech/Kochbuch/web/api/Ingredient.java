package htw.berlin.webtech.Kochbuch.web.api;

import java.util.List;

public class Ingredient {
    private long id;
    private String ingredientName;
    private int calories;

    public Ingredient(long id, String ingredientName, int calories) {
        this.id = id;
        this.ingredientName = ingredientName;
        this.calories = calories;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getingredientName() {
        return ingredientName;
    }

    public void setingredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
    public long getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
