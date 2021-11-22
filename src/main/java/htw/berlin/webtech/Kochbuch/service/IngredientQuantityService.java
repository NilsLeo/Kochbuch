package htw.berlin.webtech.Kochbuch.service;

import htw.berlin.webtech.Kochbuch.persistence.IngredientQuantityEntity;
import htw.berlin.webtech.Kochbuch.persistence.IngredientQuantityRepository;
import htw.berlin.webtech.Kochbuch.web.api.IngredientQuantity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IngredientQuantityService {
    private final IngredientQuantityRepository ingredientQuantityRepository;

    public IngredientQuantityService(IngredientQuantityRepository ingredientQuantityRepository) {
        this.ingredientQuantityRepository = ingredientQuantityRepository;
    }

    private IngredientQuantity transformIngredientQuantityEntity(IngredientQuantityEntity IngredientQuantityEntity) {
        return new IngredientQuantity(
                IngredientQuantityEntity.getIngredient().getId(),
                IngredientQuantityEntity.getQuantity(),
                IngredientQuantityEntity.getUnit()
        );
    }

    private Set<IngredientQuantity> transformIngredientQuantityEntitySet(Set<IngredientQuantityEntity> ingredientQuantityEntities) {
        Set<IngredientQuantity> set = new HashSet<>();
        ingredientQuantityEntities.forEach(ingredientQuantityEntity -> set.add(ingredientQuantityEntity.transformEntity(ingredientQuantityEntity)));
        return set;
    }

    public List<IngredientQuantity> findAll() {
        List<IngredientQuantityEntity> ingredientQuantity = ingredientQuantityRepository.findAll();
        return ingredientQuantity.stream()
                .map(this::transformIngredientQuantityEntity)
                .collect(Collectors.toList());
    }

    public List<IngredientQuantityEntity> findById_Recipeid(long recipeid) {
        var IngredientQuantityEntity = ingredientQuantityRepository.findById_Recipeid(recipeid);
        return IngredientQuantityEntity;
    }

}
