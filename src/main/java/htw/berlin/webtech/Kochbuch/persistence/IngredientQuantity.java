package htw.berlin.webtech.Kochbuch.persistence;

import javax.persistence.*;

@Entity
public class IngredientQuantity {
    @EmbeddedId
    IngredientQuantityKey id;

    @MapsId("recipeid")
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    RecipeEntity recipe;

    @MapsId("ingredientid")
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    IngredientEntity ingredient;

    int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
