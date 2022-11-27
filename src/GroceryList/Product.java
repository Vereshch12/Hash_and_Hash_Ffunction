package GroceryList;

import java.util.Objects;


public class Product {
    private String name;
    private double price;
    private double weight;

    private String status;

    public Product(String name, double price, double weight) {
        checkNaming(name);
        if (price <= 0) throw new RuntimeException("Ошибка ввода цены товара");
        if (weight <= 0) throw new RuntimeException("Ошибка ввода количества товара");
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.status = "Не куплен";
    }

    public static void checkNaming (String line){
        if (line == null || line.isEmpty() || line.isBlank()) throw new RuntimeException("Ошибка ввода названия товара!");
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.weight, weight) == 0 && Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, weight);
    }

    @Override
    public String toString() {
        return "\nПродукт: " + name +
                "\n   Цена: " + price
                + "\n   Вес: ";
    }
}
