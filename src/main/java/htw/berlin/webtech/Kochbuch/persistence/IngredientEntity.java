package htw.berlin.webtech.Kochbuch.persistence;

import htw.berlin.webtech.Kochbuch.web.api.Ingredient;
import htw.berlin.webtech.Kochbuch.web.api.Recipe;
import htw.berlin.webtech.Kochbuch.persistence.RecipeEntity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity (name = "ingredients")
public class IngredientEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ingredient_id;

    @Column(nullable = false)
    private String ingredientName;

    @Column(nullable = false)
    private int calories;

    @ManyToMany(mappedBy ="recipes")
    private List<RecipeEntity> recipeEntities;


    public IngredientEntity(String ingredientName, int calories, List <RecipeEntity> recipeEntities) {
        this.ingredientName = ingredientName;
        this.calories = calories;
        this.recipeEntities = recipeEntities;
    }



    protected IngredientEntity() {

    }

    public long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public List<RecipeEntity> getRecipeEntities() {
        return recipeEntities;
    }
    public void setRecipes(List<RecipeEntity> recipeEntities) {
        this.recipeEntities = recipeEntities;
    }

    }