package GroceryList;
import java.sql.Array;
import java.util.*;

import static GroceryList.Product.checkNaming;

public class Receipt <P extends Product>{

    private String name;
    private double totalPrice;

    private Map<Product, Double> receipt = new HashMap<>();

    public Receipt(String name) {
        checkNaming(name);
        this.name = name;
    }

    private void checkProductUniqueness(P product){
        if (receipt.containsKey(product)){
            throw new RuntimeException("Продукт " + product.getName() +" уже есть в списке рецепта. Добавьте уникальный продукт!");
        }
    }

    public void addProducts(P product){
        checkProductUniqueness(product);
        receipt.put(product, product.getWeight());
        this.totalPrice += product.getPrice()*product.getPrice();
    }

    public String getName() {
        return name;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Map<Product, Double> getReceipt() {
        return receipt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt<?> receipt1 = (Receipt<?>) o;
        return Double.compare(receipt1.totalPrice, totalPrice) == 0 && Objects.equals(name, receipt1.name) && Objects.equals(receipt, receipt1.receipt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, totalPrice, receipt);
    }

    @Override
    public String toString() {
        return "Название рецепта: " + name +
                "totalPrice=" + totalPrice +
                "receipt=" + receipt;
    }
}

