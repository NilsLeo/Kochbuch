package htw.berlin.webtech.Kochbuch.service;

import htw.berlin.webtech.Kochbuch.persistence.IngredientEntity;
import htw.berlin.webtech.Kochbuch.persistence.IngredientRepository;
import htw.berlin.webtech.Kochbuch.web.api.Ingredient;
import htw.berlin.webtech.Kochbuch.web.api.IngredientManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Ingredient findById(Long id) {
        var IngredientEntity = IngredientRepository.findById(id);
        return IngredientEntity.map(this::transformEntity).orElse(null);
    }

    public Ingredient create(IngredientManipulationRequest request) {
        var IngredientEntity = new IngredientEntity(request.getIngredientName(), request.getCalories(), request.getIngredientquantities());
        IngredientEntity = IngredientRepository.save(IngredientEntity);
        return transformEntity(IngredientEntity);
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
        return transformEntity(IngredientEntity);
    }

    private Ingredient transformEntity(IngredientEntity IngredientEntity) {
        return new Ingredient(
                IngredientEntity.getId(),
                IngredientEntity.getIngredientName(),
                IngredientEntity.getCalories(),
                IngredientEntity.getIngredientquantities()
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