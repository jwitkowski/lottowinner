package pl.sda.checker;

import java.util.List;

public interface Checker {

    List<Integer> check(List<Integer> myNumbers, List<Integer> wonNumbers) throws IllegalStateException;

}
