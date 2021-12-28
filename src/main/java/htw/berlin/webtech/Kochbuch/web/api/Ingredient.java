package htw.berlin.webtech.Kochbuch.web.api;

public class Ingredient {
    private long id;
    private String ingredientName;
    private int amount;
    private String unit;
    private Long recipeId;

    public Ingredient(long id, String ingredientName, int amount, String unit, Long recipeId) {
        this.id = id;
        this.ingredientName = ingredientName;
        this.amount = amount;
        this.unit = unit;
        this.recipeId = recipeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
}
