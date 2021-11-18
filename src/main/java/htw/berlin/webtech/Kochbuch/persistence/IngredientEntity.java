package htw.berlin.webtech.Kochbuch.persistence;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "ingredients")
public class IngredientEntity {


    @OneToMany(mappedBy = "ingredient")
    Set<IngredientQuantity> ingredientquantities;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ingredient_id;
    @Column(nullable = false)
    private String ingredientName;
    @Column(nullable = false)
    private int calories;

    public IngredientEntity(String ingredientName, int calories, Set<IngredientQuantity> ingredientquantities) {
        this.ingredientName = ingredientName;
        this.calories = calories;
        this.ingredientquantities = ingredientquantities;
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

    public Set<IngredientQuantity> getIngredientquantities() {
        return ingredientquantities;
    }

    public void setIngredientquantities(Set<IngredientQuantity> ingredientquantities) {
        this.ingredientquantities = ingredientquantities;
    }
}