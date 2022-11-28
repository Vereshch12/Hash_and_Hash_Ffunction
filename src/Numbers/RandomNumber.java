package Numbers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class RandomNumber {
    private Set<Integer> listOfNumbers = new HashSet<>();

    public RandomNumber() {
        for (int i = 0; i < 20; i++){
            listOfNumbers.add((int)(Math.random() * 1001));
        }
        System.out.println("Изначальный вариант: ");
        System.out.println(this);
    }

    public void deleteOddNumbers(){
        Iterator<Integer> odd = listOfNumbers.iterator();
        while (odd.hasNext()) {
            var integer = odd.next();
            if (integer % 2 != 0) {
                odd.remove();
            }
        }
        System.out.println("\nПосле удаления: \n" + this);

    }

    public Set<Integer> getListOfNumbers() {
        return listOfNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomNumber that = (RandomNumber) o;
        return Objects.equals(listOfNumbers, that.listOfNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfNumbers);
    }

    @Override
    public String toString() {
        return "" + listOfNumbers;
    }
}
