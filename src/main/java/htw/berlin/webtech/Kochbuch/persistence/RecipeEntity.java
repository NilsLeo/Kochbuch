package htw.berlin.webtech.Kochbuch.persistence;


import htw.berlin.webtech.Kochbuch.web.api.Ingredient;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Recipes")
public class RecipeEntity {
    //@Column ist optional:damit kann man Name und restrictions usw des sql columns festlegen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String recipeName;

    private String description;

    private int duration;

    private List<Ingredient> Ingredients;

    public RecipeEntity(String recipeName) {
        this.recipeName = recipeName;
    }

    protected RecipeEntity() {

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
        return Ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        Ingredients = ingredients;
    }
}