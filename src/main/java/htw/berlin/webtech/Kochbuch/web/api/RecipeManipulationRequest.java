package htw.berlin.webtech.Kochbuch.web.api;

public class RecipeManipulationRequest {
    private String recipeName;


    public RecipeManipulationRequest(long id, String recipeName) {
        this.recipeName = recipeName;
    }

    public String getrecipeName() {
        return recipeName;
    }

    public void setrecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    
}
