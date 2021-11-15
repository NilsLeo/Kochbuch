package htw.berlin.webtech.Kochbuch.persistence;


import javax.persistence.*;

@Entity(name = "Recipes")
public class RecipeEntity {
    //@Column ist optional:damit kann man Name und restrictions usw des sql columns festlegen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String recipeName;

    public RecipeEntity(String recipeName) {
        this.recipeName = recipeName;
    }

    protected RecipeEntity() {

    }

    public long getId() {
        return id;
    }

    public String getrecipeName() {
        return recipeName;
    }

    public void setrecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

}
