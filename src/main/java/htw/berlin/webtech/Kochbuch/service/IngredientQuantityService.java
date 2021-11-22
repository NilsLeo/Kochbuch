package htw.berlin.webtech.Kochbuch.service;

import htw.berlin.webtech.Kochbuch.persistence.IngredientQuantityEntity;
import htw.berlin.webtech.Kochbuch.persistence.IngredientQuantityRepository;
import htw.berlin.webtech.Kochbuch.persistence.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientQuantityService {
    private final IngredientQuantityRepository IngredientQuantityRepository;

    public IngredientQuantityService(IngredientQuantityRepository ingredientQuantityRepository) {
        IngredientQuantityRepository = ingredientQuantityRepository;
    }

    public List<IngredientQuantityEntity> findAll() {
        List<IngredientQuantityEntity> IngredientQuantityEntity = IngredientRepository.findAll();
        return IngredientQuantityEntity.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }
}
