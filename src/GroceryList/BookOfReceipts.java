package GroceryList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import static GroceryList.Product.checkNaming;

public class BookOfReceipts <R extends Receipt>{

    private String name;

    private Set<R> bookOfReceipts = new HashSet<>();

    public BookOfReceipts(String name) {
        checkNaming(name);
        this.name = name;
    }

    private void checkReceiptUniqueness(R receipt){
        if (bookOfReceipts.contains(receipt)){
            throw new RuntimeException("Рецепт " + receipt.getName() +" уже есть в книге рецептов. Добавьте уникальный рецепт!");
        }
    }

    public void addReceiptInBook(R receipt){
        checkReceiptUniqueness(receipt);
        bookOfReceipts.add(receipt);
    }

//    public void printBookOfReceipts(){
//        int i = 0;
//        int count;
//        for (Receipt receipt: bookOfReceipts){
//            count = 0;
//            i++;
//            System.out.println("РЕЦЕПТ №" + i + ". " + name);
//            System.out.println("Продукты входящие в рецепт: ");
//            System.out.println("|№  |Продукт         |Цена(руб)       |Количество(кг)  |Статус          |");
//            System.out.println("|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
//            for (Product product: receipt){
//                count++;
//                System.out.printf("|%-3d|%-16s|%-16.2f|%-16.2f|%-16s|\n", count,product.getName(), product.getPrice(), product.getWeight(), product.getStatus());
//                System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
//            }
//        }
//    }

    public Set<R> getBookOfReceipts() {
        return bookOfReceipts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookOfReceipts<?> that = (BookOfReceipts<?>) o;
        return Objects.equals(name, that.name) && Objects.equals(bookOfReceipts, that.bookOfReceipts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bookOfReceipts);
    }
}
