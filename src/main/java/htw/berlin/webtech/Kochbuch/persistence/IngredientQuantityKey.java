package htw.berlin.webtech.Kochbuch.persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IngredientQuantityKey implements Serializable {
    @Column(name = "recipe_id")
    Long recipeid;
    @Column(name = "ingredient_id")
    Long ingredientid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientQuantityKey that = (IngredientQuantityKey) o;
        return recipeid.equals(that.recipeid) && ingredientid.equals(that.ingredientid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeid, ingredientid);
    }

    public Long getRecipeid() {
        return recipeid;
    }

    public void setRecipeid(Long recipeid) {
        this.recipeid = recipeid;
    }

    public Long getIngredientid() {
        return ingredientid;
    }

    public void setIngredientid(Long ingredientid) {
        this.ingredientid = ingredientid;
    }
}