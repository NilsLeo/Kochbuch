package htw.berlin.webtech.Kochbuch.persistence;


import htw.berlin.webtech.Kochbuch.web.api.IngredientQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface IngredientQuantityRepository extends JpaRepository<IngredientQuantityEntity, IngredientQuantityKey> {

        List<IngredientQuantityEntity> findById_Recipeid(long recipeid);


}
