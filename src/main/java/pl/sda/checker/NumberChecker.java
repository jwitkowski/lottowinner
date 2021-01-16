package pl.sda.checker;

import java.util.ArrayList;
import java.util.List;

public class NumberChecker implements Checker {

    @Override
    public List<Integer> check(List<Integer> myNumbers, List<Integer> wonNumbers) throws IllegalStateException {
        List<Integer> hitNumbers = new ArrayList<>();

        if (myNumbers == null || wonNumbers == null) {
            return hitNumbers;
        }

        if (myNumbers.size() != wonNumbers.size()) {
            throw new IllegalStateException("Wielkosci sprawdzanych kolekcji powinny byc takie same");
        }

        for (Integer myNumber : myNumbers) {
            for (Integer wonNumber : wonNumbers) {
                if (myNumber.equals(wonNumber)) {
                    hitNumbers.add(myNumber);
                }
            }
        }

        System.out.println("trafiles: " + hitNumbers.size() + " liczb");
        System.out.println("trafione liczby: " + hitNumbers);
        return hitNumbers;
    }
}
