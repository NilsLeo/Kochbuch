package htw.berlin.webtech.Kochbuch.persistence;


import htw.berlin.webtech.Kochbuch.web.api.Ingredient;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "recipes")
public class RecipeEntity {
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
    /*
    @ManyToMany(targetEntity=IngredientEntity.class, fetch=FetchType.EAGER)
     */

    @ManyToMany
    @JoinTable(
            name = "ingredients_recipes",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients = new ArrayList<>();
    public RecipeEntity(String recipeName, String description, int duration, List <Ingredient> Ingredients) {
        this.recipeName = recipeName;
        this.description = description;
        this.duration = duration;
        this.ingredients = Ingredients;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}