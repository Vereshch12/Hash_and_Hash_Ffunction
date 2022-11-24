package GroceryList;

public class Main {

    public static void main(String[] args) {
        ProductList prizma = new ProductList<>("Призма");
        Product apple = new Product("Яблоки", 120, 1.5);
        Product lemon = new Product("Лимон", 140, 0.3 );
        prizma.printListOfProduct();
        prizma.addProductAtList(apple);
        prizma.addProductAtList(lemon);
        prizma.printListOfProduct();
        prizma.deleteProductFromList(apple);
        prizma.printListOfProduct();
        Receipt receipt1 = new Receipt("Первый рецет");
        receipt1.addProducts(apple);
        receipt1.addProducts(lemon);
        BookOfReceipts book1 = new BookOfReceipts<>("Номер одни");
        book1.addReceiptInBook(receipt1);
       // book1.printBookOfReceipts();
    }
}
