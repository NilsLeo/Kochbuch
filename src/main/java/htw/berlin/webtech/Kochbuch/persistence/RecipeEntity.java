package htw.berlin.webtech.Kochbuch.persistence;


import htw.berlin.webtech.Kochbuch.web.api.Ingredient;
import htw.berlin.webtech.Kochbuch.web.api.Recipe;

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
    @ManyToMany(targetEntity = IngredientEntity.class, fetch = FetchType.EAGER)
    @JoinTable(
            name = "ingredients_recipes",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))

    private List<IngredientEntity> ingredientEntities = new ArrayList<>();

    public RecipeEntity(String recipeName, String description, int duration, List<IngredientEntity> IngredientEntities) {
        this.recipeName = recipeName;
        this.description = description;
        this.duration = duration;
        this.ingredientEntities = ingredientEntities;
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

    public List<IngredientEntity> getIngredientEntities() {
        return ingredientEntities;
    }

    public void setIngredientEntities(List<IngredientEntity> ingredientEntities) {
        this.ingredientEntities = ingredientEntities;
    }

    // https://stackoverflow.com/questions/40035102/how-to-convert-a-list-with-properties-to-a-another-list-the-java-8-way
    public List<Ingredient> convertIngredientEntityListToIngredientList(List<IngredientEntity> ingredientEntities) {
        List <Ingredient> ingredients = new ArrayList<>();
        for (IngredientEntity ie: ingredientEntities){
            Ingredient i = new Ingredient(ie.getIngredient_id(), ie.getIngredientName(), ie.getCalories(), List.of();
            ingredients.add(i);
        }
        return ingredients;
    }
}
