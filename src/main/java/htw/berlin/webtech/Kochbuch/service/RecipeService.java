package htw.berlin.webtech.Kochbuch.service;

import htw.berlin.webtech.Kochbuch.persistence.RecipeEntity;
import htw.berlin.webtech.Kochbuch.persistence.RecipeRepository;
import htw.berlin.webtech.Kochbuch.web.api.Recipe;
import htw.berlin.webtech.Kochbuch.web.api.RecipeManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    private final RecipeRepository RecipeRepository;

    public RecipeService(RecipeRepository RecipeRepository) {
        this.RecipeRepository = RecipeRepository;
    }

    public List<Recipe> findAll() {
        List<RecipeEntity> Recipes = RecipeRepository.findAll();
        return Recipes.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Recipe findById(Long id) {
        var RecipeEntity = RecipeRepository.findById(id);
        return RecipeEntity.map(this::transformEntity).orElse(null);
    }

    public Recipe create(RecipeManipulationRequest request) {
        var RecipeEntity = new RecipeEntity(request.getRecipeName(), request.getDescription(), request.getDuration(), request.getIngredientQuantities());
        RecipeEntity = RecipeRepository.save(RecipeEntity);
        return transformEntity(RecipeEntity);
    }

    public Recipe update(Long id, RecipeManipulationRequest request) {
        var RecipeEntityOptional = RecipeRepository.findById(id);
        if (RecipeEntityOptional.isEmpty()) {
            return null;
        }
        var RecipeEntity = RecipeEntityOptional.get();
        RecipeEntity.setRecipeName(request.getRecipeName());
        RecipeEntity.setDescription(request.getDescription());
        RecipeEntity.setDuration(request.getDuration());
        RecipeEntity.setIngredientQuantities(request.getIngredientQuantities());
        RecipeEntity = RecipeRepository.save(RecipeEntity);
        return transformEntity(RecipeEntity);
    }

    private Recipe transformEntity(RecipeEntity RecipeEntity) {
        return new Recipe(
                RecipeEntity.getId(),
                RecipeEntity.getRecipeName(),
                RecipeEntity.getDescription(),
                RecipeEntity.getDuration(),
                RecipeEntity.getIngredientQuantities()
        );
    }

    public boolean deleteById(Long id) {
        if (!RecipeRepository.existsById(id)) {
            return false;
        }
        RecipeRepository.deleteById(id);
        return true;
    }
}