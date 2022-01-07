package htw.berlin.webtech.Kochbuch.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {

@Query("select r from recipe r where r.description = ?1")
RecipeEntity findByDescription(String description);

}
