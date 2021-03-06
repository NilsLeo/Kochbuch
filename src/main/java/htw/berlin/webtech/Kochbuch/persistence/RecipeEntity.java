package htw.berlin.webtech.Kochbuch.persistence;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "recipe")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column
    private String recipeName;
    @Column(length = 10000)
    private String description;
    @Column
    private int duration;
    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
    private List<IngredientEntity> ingredients = new ArrayList<>();

    public RecipeEntity(String recipeName, String description, int duration) {
        this.recipeName = recipeName;
        this.description = description;
        this.duration = duration;
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

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }
}
