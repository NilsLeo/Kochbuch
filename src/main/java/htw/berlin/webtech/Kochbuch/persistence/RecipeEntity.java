package htw.berlin.webtech.Kochbuch.persistence;


import htw.berlin.webtech.Kochbuch.web.api.Ingredient;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name = "recipes")
public class RecipeEntity {
    @OneToMany(mappedBy = "recipe")
    Set<IngredientQuantity> ingredientQuantities;
    //@Column ist optional:damit kann man Name und restrictions usw des sql columns festlegen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recipe_id;
    @Column(nullable = false)
    private String recipeName;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int duration;

    public RecipeEntity(String recipeName, String description, int duration, Set<IngredientQuantity> ingredientQuantities) {
        this.recipeName = recipeName;
        this.description = description;
        this.duration = duration;
        this.ingredientQuantities = ingredientQuantities;
    }

    protected RecipeEntity() {

    }

    public long getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(long recipe_id) {
        this.recipe_id = recipe_id;
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

    public Set<IngredientQuantity> getIngredientQuantities() {
        return ingredientQuantities;
    }

    public void setIngredientQuantities(Set<IngredientQuantity> ingredientQuantities) {
        this.ingredientQuantities = ingredientQuantities;
    }

}
