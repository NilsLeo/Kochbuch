package htw.berlin.webtech.Kochbuch.persistence;


import javax.persistence.*;
import java.util.List;

@Entity(name = "recipe")
public class RecipeEntity {
    @OneToMany(mappedBy = "recipe")
    List<IngredientQuantityEntity> ingredientQuantities;
    //@Column ist optional:damit kann man Name und restrictions usw des sql columns festlegen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String recipeName;
    @Column(nullable = false, length = 10000)
    private String description;
    @Column(nullable = false)
    private int duration;

    public RecipeEntity(String recipeName, String description, int duration, List<IngredientQuantityEntity> ingredientQuantities) {
        this.recipeName = recipeName;
        this.description = description;
        this.duration = duration;
        this.ingredientQuantities = ingredientQuantities;
    }

    protected RecipeEntity() {

    }

    public long getId() {
        return id;
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

    public List<IngredientQuantityEntity> getIngredientQuantities() {
        return ingredientQuantities;
    }

    public void setIngredientQuantities(List<IngredientQuantityEntity> ingredientQuantities) {
        this.ingredientQuantities = ingredientQuantities;
    }
}
