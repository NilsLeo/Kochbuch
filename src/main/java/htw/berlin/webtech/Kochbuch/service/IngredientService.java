package htw.berlin.webtech.Kochbuch.service;

import htw.berlin.webtech.Kochbuch.persistence.IngredientEntity;
import htw.berlin.webtech.Kochbuch.persistence.IngredientQuantityEntity;
import htw.berlin.webtech.Kochbuch.persistence.IngredientRepository;
import htw.berlin.webtech.Kochbuch.web.api.Ingredient;
import htw.berlin.webtech.Kochbuch.web.api.IngredientManipulationRequest;
import htw.berlin.webtech.Kochbuch.web.api.IngredientQuantity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> findAll() {
        List<IngredientEntity> Ingredients = ingredientRepository.findAll();
        return Ingredients.stream()
                .map(this::transformIngredientEntity)
                .collect(Collectors.toList());
    }

    public Ingredient findById(Long id) {
        var ingredientEntity = ingredientRepository.findById(id);
        return ingredientEntity.map(this::transformIngredientEntity).orElse(null);
    }
    public Ingredient findByIngredientName(String ingredientName){
        var ingredientEntity=ingredientRepository.findByIngredientName(ingredientName);
        return transformIngredientEntity(ingredientEntity);
    }
    public Ingredient create(IngredientManipulationRequest request) {
        var IngredientEntity = new IngredientEntity(request.getIngredientName(), request.getCalories(), request.getIngredientQuantities());
        IngredientEntity = ingredientRepository.save(IngredientEntity);
        return transformIngredientEntity(IngredientEntity);
    }

    public Ingredient update(Long id, IngredientManipulationRequest request) {
        var IngredientEntityOptional = ingredientRepository.findById(id);
        if (IngredientEntityOptional.isEmpty()) {
            return null;
        }
        var IngredientEntity = IngredientEntityOptional.get();
        IngredientEntity.setIngredientName(request.getIngredientName());
        IngredientEntity.setCalories(request.getCalories());
        IngredientEntity = ingredientRepository.save(IngredientEntity);
        return transformIngredientEntity(IngredientEntity);
    }

    private IngredientQuantity transformIngredientQuantityEntity(IngredientQuantityEntity IngredientQuantityEntity) {
        return new IngredientQuantity(
                IngredientQuantityEntity.getRecipe().getId(),
                IngredientQuantityEntity.getIngredient().getId(),
                IngredientQuantityEntity.getQuantity(),
                IngredientQuantityEntity.getUnit()
        );
    }

    private Ingredient transformIngredientEntity(IngredientEntity ingredientEntity) {

        return new Ingredient(
                ingredientEntity.getId(),
                ingredientEntity.getIngredientName(),
                ingredientEntity.getCalories(),
                ingredientEntity.getIngredientQuantities().stream().map(this::transformIngredientQuantityEntity).collect(Collectors.toList())

        );
    }

    public boolean deleteById(Long id) {
        if (!ingredientRepository.existsById(id)) {
            return false;
        }
        ingredientRepository.deleteById(id);
        return true;
    }
}