package MultiplicationTable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PairOfNumbers {
    private Set<String> pairsOfNumbers = new HashSet<>();

    private String generateNumbers() {
        int a;
        int b;
        a = 2 + (int) (Math.random() * 8);
        b = 2 + (int)(Math.random() * 8);
        String generationTask = a + "*" + b;
        return generationTask;
    }

    private boolean checkNumbers(String numbers){
        String anotherGenerationTask = numbers.charAt(2) + "*" + numbers.charAt(0);
        for (String task: pairsOfNumbers){
            if (numbers.equals(task) || anotherGenerationTask.equals(task)){
                return true;
            }
        }
        return false;
    }

    public void createAllTasks(){
        while (pairsOfNumbers.size() < 15){
            String generationTask  = generateNumbers();
            while (checkNumbers(generationTask)){
                generationTask  = generateNumbers();
            }
            pairsOfNumbers.add(generationTask);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairOfNumbers that = (PairOfNumbers) o;
        return Objects.equals(pairsOfNumbers, that.pairsOfNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pairsOfNumbers);
    }

    @Override
    public String toString() {
        return "PairOfNumbers{" +
                "pairsOfNumbers=" + pairsOfNumbers +
                '}';
    }
}
