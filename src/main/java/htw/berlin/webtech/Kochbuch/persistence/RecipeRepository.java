package htw.berlin.webtech.Kochbuch.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {

RecipeEntity findByDescription(String description);

}
