package htw.berlin.webtech.Kochbuch.web.api;

public class IngredientQuantityManipulationRequest {
    long recipeid;
    long ingredientid;
    int quantity;
    String unit;

    public IngredientQuantityManipulationRequest(long recipeid, long ingredientid, int quantity, String unit) {
        this.recipeid = recipeid;
        this.ingredientid = ingredientid;
        this.quantity = quantity;
        this.unit = unit;
    }

    public long getRecipeid() {
        return recipeid;
    }

    public void setRecipeid(long recipeid) {
        this.recipeid = recipeid;
    }

    public long getIngredientid() {
        return ingredientid;
    }

    public void setIngredientid(long ingredientid) {
        this.ingredientid = ingredientid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
