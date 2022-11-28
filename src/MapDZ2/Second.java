package MapDZ2;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Second {

    private Map<Integer, String> second = new LinkedHashMap<>();

    public Map<Integer, String> generateInitialCollection() {
        String str = "";
        for (int i = 0; i < 10; i++) {
            str = "str" + (i + 1);
            second.put(i + 1, str);
        }
        return second;
    }

    @Override
    public String toString() {
        String conclusion = "";
        for (Integer key: second.keySet()){
            conclusion += key + ": " + second.get(key) + "\n";
        }
        return conclusion;
    }
}
