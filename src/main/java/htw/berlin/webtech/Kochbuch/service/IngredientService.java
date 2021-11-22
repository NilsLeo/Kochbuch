package htw.berlin.webtech.Kochbuch.service;

import htw.berlin.webtech.Kochbuch.persistence.IngredientEntity;
import htw.berlin.webtech.Kochbuch.persistence.IngredientRepository;
import htw.berlin.webtech.Kochbuch.web.api.Ingredient;
import htw.berlin.webtech.Kochbuch.web.api.IngredientManipulationRequest;
import htw.berlin.webtech.Kochbuch.web.api.IngredientQuantity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    private final IngredientRepository IngredientRepository;

    public IngredientService(IngredientRepository IngredientRepository) {
        this.IngredientRepository = IngredientRepository;
    }

    public List<Ingredient> findAll() {
        List<IngredientEntity> Ingredients = IngredientRepository.findAll();
        return Ingredients.stream()
                .map(this::transformIngredientEntity)
                .collect(Collectors.toList());
    }

    public Ingredient findById(Long id) {
        var IngredientEntity = IngredientRepository.findById(id);
        return IngredientEntity.map(this::transformIngredientEntity).orElse(null);
    }

    public Ingredient create(IngredientManipulationRequest request) {
        var IngredientEntity = new IngredientEntity(request.getIngredientName(), request.getCalories(), request.getIngredientquantities());
        IngredientEntity = IngredientRepository.save(IngredientEntity);
        return transformIngredientEntity(IngredientEntity);
    }

    public Ingredient update(Long id, IngredientManipulationRequest request) {
        var IngredientEntityOptional = IngredientRepository.findById(id);
        if (IngredientEntityOptional.isEmpty()) {
            return null;
        }
        var IngredientEntity = IngredientEntityOptional.get();
        IngredientEntity.setIngredientName(request.getIngredientName());
        IngredientEntity.setCalories(request.getCalories());
        IngredientEntity = IngredientRepository.save(IngredientEntity);
        return transformIngredientEntity(IngredientEntity);
    }

    private Ingredient transformIngredientEntity(IngredientEntity ingredientEntity) {
        Set<IngredientQuantity> set = new HashSet<>();
        ingredientEntity.getIngredientQuantities().forEach(e -> set.add(e.transformEntity(e)));

        return new Ingredient(
                ingredientEntity.getId(),
                ingredientEntity.getIngredientName(),
                ingredientEntity.getCalories(),
                set
        );
    }

    public boolean deleteById(Long id) {
        if (!IngredientRepository.existsById(id)) {
            return false;
        }
        IngredientRepository.deleteById(id);
        return true;
    }
}