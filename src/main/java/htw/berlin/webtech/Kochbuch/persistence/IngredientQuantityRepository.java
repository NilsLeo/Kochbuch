package htw.berlin.webtech.Kochbuch.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientQuantityRepository extends JpaRepository<IngredientQuantityEntity, IngredientQuantityKey> {

    List<IngredientQuantityEntity> findAllByIngredientQuantity(int ingredientQuantity);

    List<IngredientQuantityEntity> findById_Recipeid(long recipeid);
}
