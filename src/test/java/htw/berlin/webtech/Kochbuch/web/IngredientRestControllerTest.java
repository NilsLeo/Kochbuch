package htw.berlin.webtech.Kochbuch.web;

import htw.berlin.webtech.Kochbuch.service.IngredientService;
import htw.berlin.webtech.Kochbuch.web.api.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(IngredientRestController.class)
class IngredientRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IngredientService mockIngredientService;


    @Test
    @DisplayName("should return 404 if ingredient is not found")
    void should_return_404_if_ingredient_is_not_found() throws Exception {
        doReturn(null).when(mockIngredientService).findById(anyLong());

        mockMvc.perform(get("/api/v1/Ingredients/123"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return ingredient if found")
    void testFetchIngredientById() throws Exception {
        long id = 0;
        var ingredient = new Ingredient(0l, "name", 0, "g", 0L);

        doReturn(ingredient).when(mockIngredientService).findById(id);

        mockMvc.perform(get("/api/v1/Ingredients/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(0))
                .andExpect(jsonPath("$.ingredientName").value("name"))
                .andExpect(jsonPath("$.amount").value(0))
                .andExpect(jsonPath("$.unit").value("g"))
                .andExpect(jsonPath("$.recipeId").value(0));
    }

}
