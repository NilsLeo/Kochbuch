package htw.berlin.webtech.Kochbuch.service;

import htw.berlin.webtech.Kochbuch.persistence.RecipeRepository;
import htw.berlin.webtech.Kochbuch.web.api.Recipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeServiceTest {

    @Mock
    private RecipeRepository mockRecipeRepository;
    @Mock
    private RecipeTransformer mockRecipeTransformer;
    @InjectMocks
    private RecipeService recipeServiceUnderTest;

    @Test
    @DisplayName("should return true if delete was successful")
    void should_return_true_if_delete_was_successful() {
        Long givenId = 110L;
        doReturn(true).when(mockRecipeRepository).existsById(givenId);

        boolean result = recipeServiceUnderTest.deleteById(givenId);

        verify(mockRecipeRepository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if delete was successful")
    void should_return_false_if_delete_was_successful() {
        Long givenId = 110L;
        doReturn(false).when(mockRecipeRepository).existsById(givenId);

        boolean result = recipeServiceUnderTest.deleteById(givenId);

        verifyNoMoreInteractions(mockRecipeRepository);
        assertThat(result).isFalse();
    }

    @Test
    void testFindAll_RecipeRepositoryReturnsNoItems() {

        when(mockRecipeRepository.findAll()).thenReturn(Collections.emptyList());


        final List<Recipe> result = recipeServiceUnderTest.findAll();


        assertThat(result).isEqualTo(Collections.emptyList());
    }

}
