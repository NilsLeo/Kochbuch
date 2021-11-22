package htw.berlin.webtech.Kochbuch.persistence;


import javax.persistence.*;
import java.util.Set;

@Entity(name = "recipe")
public class RecipeEntity {
    @OneToMany(mappedBy = "recipe")
    Set<IngredientQuantityEntity> ingredientQuantities;
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

    public RecipeEntity(String recipeName, String description, int duration, Set<IngredientQuantityEntity> ingredientQuantities) {
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

    public Set<IngredientQuantityEntity> getIngredientQuantities() {
        return ingredientQuantities;
    }

    public void setIngredientQuantities(Set<IngredientQuantityEntity> ingredientQuantities) {
        this.ingredientQuantities = ingredientQuantities;
    }

}
