import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvenOrOddTest {

    @Test
    public void test_even1() throws IllegalArgumentException{
        EvenOrOdd test1 = new EvenOrOdd();
        assertEquals("even",test1.is_even(6));
    }
    @Test
    public void test_even2() throws IllegalArgumentException{
        EvenOrOdd test2 = new EvenOrOdd();
        assertEquals("even",test2.is_even(160));
    }
    @Test
    public void test_odd1() throws IllegalArgumentException{
        EvenOrOdd test3 = new EvenOrOdd();
        assertEquals("odd",test3.is_even(5));
    }
    @Test
    public void test_odd2() throws IllegalArgumentException{
        EvenOrOdd test4 = new EvenOrOdd();
        assertEquals("odd",test4.is_even(65));
    }

}