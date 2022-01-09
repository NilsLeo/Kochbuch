package htw.berlin.webtech.Kochbuch.service;

import htw.berlin.webtech.Kochbuch.persistence.IngredientEntity;
import htw.berlin.webtech.Kochbuch.persistence.RecipeEntity;
import htw.berlin.webtech.Kochbuch.persistence.Unit;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doReturn;

public class IngredientTransformerTest implements WithAssertions {

    private final IngredientTransformer underTest = new IngredientTransformer();

    @Test
    @DisplayName("should transform Ingrediententity to Ingredient")
    void should_transform_ingredient_entity_to_ingredient() {
        var ingredientEntity = Mockito.mock(IngredientEntity.class);
        var recipeEntity = Mockito.mock(RecipeEntity.class);
        doReturn(112L).when(recipeEntity).getId();
        doReturn(110L).when(ingredientEntity).getId();
        doReturn("Parmesan").when(ingredientEntity).getIngredientName();
        doReturn(20).when(ingredientEntity).getAmount();
        doReturn(Unit.Kg).when(ingredientEntity).getUnit();
        doReturn(recipeEntity).when(ingredientEntity).getRecipe();

        var result = underTest.transformEntity(ingredientEntity);

        assertThat(result.getId()).isEqualTo(110);
        assertThat(result.getIngredientName()).isEqualTo("Parmesan");
        assertThat(result.getAmount()).isEqualTo(20);
        assertThat(result.getUnit()).isEqualTo("Kg");
        assertThat(result.getRecipeId()).isEqualTo(112);
    }
}
