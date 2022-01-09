package htw.berlin.webtech.Kochbuch.persistence;

import javax.persistence.*;

@Entity(name = "ingredient")
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String ingredientName;
    @Column
    private int amount;
    @Column
    @Enumerated(value = EnumType.STRING)
    private Unit unit;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private RecipeEntity recipe;

    public IngredientEntity(String ingredientName, int amount, Unit unit, RecipeEntity recipe) {
        this.ingredientName = ingredientName;
        this.amount = amount;
        this.unit = unit;
        this.recipe = recipe;
    }

    protected IngredientEntity() {

    }

    public long getId() {
        return id;
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

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }
}
