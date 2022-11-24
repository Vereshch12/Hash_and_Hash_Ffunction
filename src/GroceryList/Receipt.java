package GroceryList;
import java.sql.Array;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import static GroceryList.Product.checkNaming;

public class Receipt <P extends Product>{

    private String name;
    private double totalPrice;

    private Set<P> receipt = new HashSet<>();

    public Receipt(String name) {
        checkNaming(name);
        this.name = name;
    }

    private void checkProductUniqueness(P product){
        if (receipt.contains(product)){
            throw new RuntimeException("Продукт " + product.getName() +" уже есть в списке рецепта. Добавьте уникальный продукт!");
        }
    }

    public void addProducts(P product){
        checkProductUniqueness(product);
        receipt.add(product);
        this.totalPrice += product.getPrice();
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "name='" + name + '\'' +
                ", totalPrice=" + totalPrice +
                ", receipt=" + receipt +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Set<P> getReceipt() {
        return receipt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt<?> receipt1 = (Receipt<?>) o;
        return Objects.equals(name, receipt1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, totalPrice, receipt);
    }


}

