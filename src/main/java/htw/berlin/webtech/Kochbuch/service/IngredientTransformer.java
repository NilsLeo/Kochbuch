package htw.berlin.webtech.Kochbuch.service;

import htw.berlin.webtech.Kochbuch.persistence.IngredientEntity;
import htw.berlin.webtech.Kochbuch.persistence.Unit;
import htw.berlin.webtech.Kochbuch.web.api.Ingredient;
import org.springframework.stereotype.Service;

@Service
public class IngredientTransformer {

    public Ingredient transformEntity(IngredientEntity ingredientEntity) {
        var unit = ingredientEntity.getUnit() != null ? ingredientEntity.getUnit().name() : Unit.Unknown.name();
        return new Ingredient(
                ingredientEntity.getId(),
                ingredientEntity.getIngredientName(),
                ingredientEntity.getAmount(),
                unit,
                ingredientEntity.getRecipe().getId()
        );
    }
}
