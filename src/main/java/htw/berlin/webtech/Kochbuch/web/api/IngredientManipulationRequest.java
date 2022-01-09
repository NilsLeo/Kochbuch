package htw.berlin.webtech.Kochbuch.web.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class IngredientManipulationRequest {
    private String ingredientName;
    private int amount;
    private String unit;
    private Long recipeId;

    public IngredientManipulationRequest(String ingredientName, int amount, String unit, Long recipeId) {
        this.ingredientName = ingredientName;
        this.amount = amount;
        this.unit = unit;
        this.recipeId = recipeId;
    }

    public IngredientManipulationRequest(){

    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
