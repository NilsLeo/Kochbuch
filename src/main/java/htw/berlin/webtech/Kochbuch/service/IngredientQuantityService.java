package htw.berlin.webtech.Kochbuch.service;

import htw.berlin.webtech.Kochbuch.persistence.IngredientQuantityEntity;
import htw.berlin.webtech.Kochbuch.persistence.IngredientQuantityRepository;
import htw.berlin.webtech.Kochbuch.web.api.IngredientQuantity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientQuantityService {
    private final IngredientQuantityRepository ingredientQuantityRepository;

    public IngredientQuantityService(IngredientQuantityRepository ingredientQuantityRepository) {
        this.ingredientQuantityRepository = ingredientQuantityRepository;
    }

    public IngredientQuantity transformIngredientQuantityEntity(IngredientQuantityEntity IngredientQuantityEntity) {
        return new IngredientQuantity(
                IngredientQuantityEntity.getRecipe().getId(),
                IngredientQuantityEntity.getIngredient().getId(),
                IngredientQuantityEntity.getQuantity(),
                IngredientQuantityEntity.getUnit()
        );
    }

    private List<IngredientQuantity> transformIngredientQuantityEntityList(List<IngredientQuantityEntity> ingredientQuantityEntities) {
        return ingredientQuantityEntities.stream()
                .map(this::transformIngredientQuantityEntity)
                .collect(Collectors.toList());
    }

    public List<IngredientQuantity> findAll() {
        List<IngredientQuantityEntity> ingredientQuantity = ingredientQuantityRepository.findAll();
        return ingredientQuantity.stream()
                .map(this::transformIngredientQuantityEntity)
                .collect(Collectors.toList());
    }

    public List<IngredientQuantity> findByRecipeid(long recipeid) {
        var IngredientQuantityEntity = ingredientQuantityRepository.findById_Recipeid(recipeid);
        return IngredientQuantityEntity.stream().map(this::transformIngredientQuantityEntity).collect(Collectors.toList());
    }

}
