package htw.berlin.webtech.Kochbuch.web;

import htw.berlin.webtech.Kochbuch.service.RecipeService;
import htw.berlin.webtech.Kochbuch.web.api.Recipe;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RecipeRestController.class)
class RecipeRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService mockRecipeService;
    @MockBean
    private IngredientRestController mockIngredientRestController;

    @Test
    @DisplayName("should fetch all recipes from recipe service")
    void testFetchRecipes() throws Exception {
        final List<Recipe> recipes = List.of(
                new Recipe(0L, "recipeName", "description", 0, Collections.emptyList()),
                new Recipe(1L, "recipeName1", "description1", 1, Collections.emptyList())
        );
        doReturn(recipes).when(mockRecipeService).findAll();


        mockMvc.perform(get("/api/v1/Recipes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(0))
                .andExpect(jsonPath("$[0].recipeName").value("recipeName"))
                .andExpect(jsonPath("$[0].description").value("description"))
                .andExpect(jsonPath("$[0].duration").value("0"))
                .andExpect(jsonPath("$[1].id").value(1))
                .andExpect(jsonPath("$[1].recipeName").value("recipeName1"))
                .andExpect(jsonPath("$[1].description").value("description1"))
                .andExpect(jsonPath("$[1].duration").value("1"));

    }

    @Test
    void testFetchRecipes_RecipeServiceReturnsNoItems() throws Exception {
        when(mockRecipeService.findAll()).thenReturn(Collections.emptyList());
        final MockHttpServletResponse response = mockMvc.perform(get("/api/v1/Recipes")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    @DisplayName("should return recipe if found")
    void testFetchRecipeById() throws Exception {
        long id = 0;
        var recipe = new Recipe(0L, "recipeName", "description", 0, Collections.emptyList());

        doReturn(recipe).when(mockRecipeService).findById(id);

        mockMvc.perform(get("/api/v1/Recipes/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(0))
                .andExpect(jsonPath("$.recipeName").value("recipeName"))
                .andExpect(jsonPath("$.description").value("description"))
                .andExpect(jsonPath("$.duration").value("0"));
    }

    @Test
    @DisplayName("should return 404 if recipe is not found")
    void should_return_404_if_recipe_is_not_found() throws Exception {
        doReturn(null).when(mockRecipeService).findById(anyLong());

        mockMvc.perform(get("/api/v1/Recipes/123"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a recipe")
    void should_return_201_http_status_and_location_header_when_creating_a_recipe() throws Exception {
        String recipeToCreateAsJson = "{\"recipeName\": \"recipeName\", \"description\":\"description\"}";
        var recipe = new Recipe(0L, null, null, 1, null);
        mockMvc.perform(
                        post("/api/v1/Recipes/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(recipeToCreateAsJson))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/Recipes/" + recipe.getId()))));
    }

}
