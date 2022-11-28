package MapDZ2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class First {

    private Map<String, List<Integer>> first = new HashMap<>();
    private Map<String, Integer> newFirst = new HashMap<>();


    public First() {
    }

    private List<Integer> generateValue(){
        List<Integer> lI = new ArrayList<>();
        while(lI.size() != 3){
            lI.add((int)(Math.random() * 1001));
        }
        return lI;
    }

    public Map<String, List<Integer>> generateInitialCollection() {
        String str = "";
        for (int i = 0; i < 5; i++) {
            str = "str" + (i + 1);
            first.put(str, generateValue());
        }
        return first;
    }

    public Map<String, Integer> changeCollection(){
        int sum = 0;
        for (String key: first.keySet()){
            sum = 0;
            List<Integer> helpingList = first.get(key);
            for (Integer sumFromList: helpingList){
                sum += sumFromList;
            }
            newFirst.put(key, sum);
        }
        return newFirst;
    }
}
