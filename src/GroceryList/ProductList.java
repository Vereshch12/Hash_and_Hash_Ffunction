package GroceryList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import static GroceryList.Product.checkNaming;

public class ProductList <P extends Product>{

    private String name;

    public ProductList(String name) {
        checkNaming(name);
        this.name = name;
    }

    private Set<P> listOfProduct = new HashSet<>();

    private void checkProductUniqueness(P product){
        if (listOfProduct.contains(product)){
            throw new RuntimeException("Продукт " + product.getName() +" уже есть в списке. Добавьте уникальный продукт!");
        }
    }

    public void addProductAtList(P product){
        checkProductUniqueness(product);
        listOfProduct.add(product);
        System.out.printf("Продукт %s добавлен в список покупок %s\n", product.getName(), name);
    }

    public void markProductAsPurchased(P product){
        product.setStatus("Купленный");
    }

    public void deleteProductFromList(P product){
        listOfProduct.remove(product);
        System.out.printf("Продукт %s удален из списка покупок %s\n", product.getName(), name);
    }

    public void printListOfProduct(){
        int count = 0;
        System.out.println("\nНАЗВАНИЕ СПИСКА ПОКУПОК: " + name + "\n|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
        System.out.println("|№  |Продукт         |Цена(руб)       |Количество(кг)  |Статус          |");
        System.out.println("|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
        for (P product: listOfProduct){
            count++;
            System.out.printf("|%-3d|%-16s|%-16.2f|%-16.2f|%-16s|\n", count,product.getName(), product.getPrice(), product.getWeight(), product.getStatus());
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        }
    }

    public String getName() {
        return name;
    }

    public Set<P> getListOfProduct() {
        return listOfProduct;
    }

    public void setName(String name) {
        checkNaming(name);
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductList<?> that = (ProductList<?>) o;
        return Objects.equals(name, that.name) && Objects.equals(listOfProduct, that.listOfProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, listOfProduct);
    }


}
