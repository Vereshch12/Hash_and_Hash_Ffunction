package MapDZ2;

public class Main {
    public static void main(String[] args) {
        First first = new First();
        System.out.println(first.generateInitialCollection());
        System.out.println(first.changeCollection());
        Second second = new Second();
        System.out.println(second.generateInitialCollection());
        System.out.println(second);
    }
}
