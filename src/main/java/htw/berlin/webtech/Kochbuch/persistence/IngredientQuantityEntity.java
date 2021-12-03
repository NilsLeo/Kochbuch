package htw.berlin.webtech.Kochbuch.persistence;

import htw.berlin.webtech.Kochbuch.web.api.IngredientQuantity;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class IngredientQuantityEntity {
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
    @Column(nullable = false)
    int quantity;
    @Column(nullable = false)
    String unit;

    protected IngredientQuantityEntity() {

    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}