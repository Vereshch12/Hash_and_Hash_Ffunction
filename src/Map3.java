import java.util.HashMap;
import java.util.Map;

public class Map3 {
    private static Map<String, Integer> first = new HashMap<>();

    private static void addNew(String str, Integer i){
        if (!first.containsKey(str)){
            first.put(str, i);
        } else {
            if (first.containsValue(i)){
                throw new RuntimeException("Такой ключ и значение уже есть!");
            } else {
                first.put(str, i);
            }
        }

    }

    public static void main(String[] args) {
        addNew("a", 23);
        addNew("b", 33);
        addNew("c", 2345);
        addNew("d", 235);
        System.out.println(first);
        addNew("c", 25);
        System.out.println(first);
    }
}
