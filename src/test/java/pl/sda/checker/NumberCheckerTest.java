package pl.sda.checker;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NumberCheckerTest {

    private NumberChecker sut;

    @Before
    public void setUp() throws Exception {
        sut = new NumberChecker();
    }

    @Test
    public void should_return_empty_hit_list_when_both_check_numbers_are_null() {
        List<Integer> result = sut.check(null, null);

        assertNotNull(result);
        assertEquals(0, result.size());
    }


    @Test(expected = IllegalStateException.class)
    public void should_throws_exception_when_lists_are_not_even() {
        List<Integer> myNumbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> wonNumbers = Arrays.asList(1, 2, 3, 4);

        sut.check(myNumbers, wonNumbers);
    }

    @Test
    public void should_return_win_numbers_when_lists_are_not_sorted() {
        List<Integer> myNumbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> wonNumbers = Arrays.asList(5, 3, 2, 1, 4);

        List<Integer> result = sut.check(myNumbers, wonNumbers);
        assertThat(result, is(myNumbers));
    }

    @Test
    public void should_return_win_numbers() {
        List<Integer> myNumbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> wonNumbers = Arrays.asList(35, 1, 20, 2, 40);

        List<Integer> result = sut.check(myNumbers, wonNumbers);
        assertThat(result, is(Arrays.asList(1, 2)));
    }
}