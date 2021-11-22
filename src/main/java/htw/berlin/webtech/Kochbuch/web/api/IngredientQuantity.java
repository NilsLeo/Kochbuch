package htw.berlin.webtech.Kochbuch.web.api;

import htw.berlin.webtech.Kochbuch.persistence.IngredientEntity;
import htw.berlin.webtech.Kochbuch.persistence.IngredientQuantityKey;
import htw.berlin.webtech.Kochbuch.persistence.RecipeEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

public class IngredientQuantity {
    IngredientQuantityKey id;
    RecipeEntity recipe;
    IngredientEntity ingredient;

    public IngredientQuantity(IngredientQuantityKey id, RecipeEntity recipe, IngredientEntity ingredient) {
        this.id = id;
        this.recipe = recipe;
        this.ingredient = ingredient;
    }

    public IngredientQuantityKey getId() {
        return id;
    }

    public void setId(IngredientQuantityKey id) {
        this.id = id;
    }

    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }

    public IngredientEntity getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientEntity ingredient) {
        this.ingredient = ingredient;
    }
}
