package htw.berlin.webtech.Kochbuch.web.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RecipeManipulationRequest {
    @NotBlank (message="Name must not be empty")
    private String recipeName;
    @NotBlank (message="Description must not be empty")
    private String description;
    @NotNull(message="Duration must not be empty")
    private int duration;

    public RecipeManipulationRequest(String recipeName, String description, int duration) {
        this.recipeName = recipeName;
        this.description = description;
        this.duration = duration;
    }
    public RecipeManipulationRequest(){

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

}

