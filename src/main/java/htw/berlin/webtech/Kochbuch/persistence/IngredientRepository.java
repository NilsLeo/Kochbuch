package htw.berlin.webtech.Kochbuch.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {

    List<RecipeEntity> findAllByIngredientName(String ingredientName);
}
