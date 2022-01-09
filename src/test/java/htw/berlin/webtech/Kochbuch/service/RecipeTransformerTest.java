package htw.berlin.webtech.Kochbuch.service;

import htw.berlin.webtech.Kochbuch.persistence.RecipeEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class RecipeTransformerTest implements WithAssertions {
    @Mock
    private IngredientTransformer ingredientTransformer;
    @InjectMocks
    private RecipeTransformer recipeTransformerUnderTest;


    @Test
    @DisplayName("should transform Recipeentity to recipe")
    void should_transform_recipe_entity_to_recipe() {
        var recipeEntity = Mockito.mock(RecipeEntity.class);
        doReturn(112L).when(recipeEntity).getId();
        doReturn("name").when(recipeEntity).getRecipeName();
        doReturn("description").when(recipeEntity).getDescription();
        doReturn(1).when(recipeEntity).getDuration();
        doReturn(Collections.emptyList()).when(recipeEntity).getIngredients();

        var result = recipeTransformerUnderTest.transformEntity(recipeEntity);

        assertThat(result.getId()).isEqualTo(112);
        assertThat(result.getRecipeName()).isEqualTo("name");
        assertThat(result.getDescription()).isEqualTo("description");
        assertThat(result.getDuration()).isEqualTo(1);
        assertThat(result.getIngredients()).isEqualTo(Collections.emptyList());
    }
}
