package htw.berlin.webtech.Kochbuch.persistence;

import htw.berlin.webtech.Kochbuch.web.api.IngredientQuantity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "ingredient")
public class IngredientEntity {


    @OneToMany(mappedBy = "ingredient",fetch = FetchType.EAGER)
    List<IngredientQuantityEntity> ingredientQuantities;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column(nullable = false)
    private String ingredientName;
    @Column(nullable = false)
    private int calories;

    public IngredientEntity(String ingredientName, int calories, List<IngredientQuantityEntity> ingredientquantities) {
        this.ingredientName = ingredientName;
        this.calories = calories;
        this.ingredientQuantities = ingredientquantities;
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

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public List<IngredientQuantityEntity> getIngredientQuantities() {
        return ingredientQuantities;
    }

    public void setIngredientQuantities(List<IngredientQuantityEntity> ingredientQuantities) {
        this.ingredientQuantities = ingredientQuantities;
    }

}