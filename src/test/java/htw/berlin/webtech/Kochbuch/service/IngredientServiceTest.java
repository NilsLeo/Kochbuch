package htw.berlin.webtech.Kochbuch.service;

import htw.berlin.webtech.Kochbuch.persistence.IngredientRepository;
import htw.berlin.webtech.Kochbuch.persistence.RecipeRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IngredientServiceTest implements WithAssertions {
    @Mock
    private IngredientRepository ingredientRepository;
    @Mock
    private RecipeRepository recipeRepository;
    @Mock
    private IngredientTransformer ingredientTransformer;
    @InjectMocks
    private IngredientService underTest;

    @Test
    @DisplayName("should return true if delete was successful")
    void should_return_true_if_delete_was_successful() {
        Long givenId = 110L;
        doReturn(true).when(ingredientRepository).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verify(ingredientRepository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if delete was successful")
    void should_return_false_if_delete_was_successful() {
        Long givenId = 110L;
        doReturn(false).when(ingredientRepository).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verifyNoMoreInteractions(ingredientRepository);
        assertThat(result).isFalse();
    }
}
