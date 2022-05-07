import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class stateTest {
    @Nested
    class EdgeCoverage {

        state Obj1;

        @BeforeEach
        public void setup() {
            Obj1 = new state();
        }

        @Test
        public void Test1() {
            String[] result = Obj1.InState('a');
            assertEquals("NORMAL", result[0]);
            assertEquals("DATE", result[1]);
            assertEquals("2000-1-1", result[2]);
            assertEquals("0:0", result[3]);
        }

        @Test
        public void Test2() {
            Obj1.InState('a');
            String[] result = Obj1.InState('a');
            assertEquals("NORMAL", result[0]);
            assertEquals("TIME", result[1]);
            assertEquals("2000-1-1", result[2]);
            assertEquals("0:0", result[3]);
        }

        @Test
        public void Test3() {
            Obj1.InState('a');
            Obj1.InState('a');
            String[] res = Obj1.InState('c');
            assertEquals("UPDATE", res[0]);
            assertEquals("min", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("0:0", res[3]);
        }

        @Test
        public void Test4() {
            Obj1.InState('a');
            Obj1.InState('a');
            Obj1.InState('c');
            String[] result = Obj1.InState('b');
            assertEquals("UPDATE", result[0]);
            assertEquals("min", result[1]);
            assertEquals("2000-1-1", result[2]);
            assertEquals("0:1", result[3]);
        }

        @Test
        public void Test5() {
            Obj1.InState('a');
            Obj1.InState('a');
            Obj1.InState('c');
            Obj1.InState('b');
            String[] result = Obj1.InState('a');
            assertEquals("UPDATE", result[0]);
            assertEquals("hour", result[1]);
            assertEquals("2000-1-1", result[2]);
            assertEquals("0:1", result[3]);
        }

        @Test
        public void Test6() {
            Obj1.InState('a');
            Obj1.InState('a');
            Obj1.InState('c');
            Obj1.InState('b');
            Obj1.InState('a');
            String[] result = Obj1.InState('b');
            assertEquals("UPDATE", result[0]);
            assertEquals("hour", result[1]);
            assertEquals("2000-1-1", result[2]);
            assertEquals("1:1", result[3]);
        }

        @Test
        public void Test7() {
            Obj1.InState('a');
            Obj1.InState('a');
            Obj1.InState('c');
            Obj1.InState('b');
            Obj1.InState('a');
            Obj1.InState('b');
            String[] result = Obj1.InState('a');
            assertEquals("UPDATE", result[0]);
            assertEquals("day", result[1]);
            assertEquals("2000-1-1", result[2]);
            assertEquals("1:1", result[3]);
        }

        @Test
        public void Test8() {
            Obj1.InState('a');
            Obj1.InState('a');
            Obj1.InState('c');
            Obj1.InState('b');
            Obj1.InState('a');
            Obj1.InState('b');
            Obj1.InState('a');
            String[] result = Obj1.InState('b');
            assertEquals("UPDATE", result[0]);
            assertEquals("day", result[1]);
            assertEquals("2000-1-2", result[2]);
            assertEquals("1:1", result[3]);
        }
    }

    @Nested
    class ADUP {

        state mainObj1;

        @BeforeEach
        public void setup() {
            mainObj1 = new state();
        }

        @Test
        public void ADUPtest1() {
            String[] res = mainObj1.InState('c');
            assertEquals("UPDATE", res[0]);
            assertEquals("min", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("0:0", res[3]);
        }

        @Test
        public void ADUPtest2() {
            mainObj1.InState('c');
            String[] res = mainObj1.InState('b');
            assertEquals("UPDATE", res[0]);
            assertEquals("min", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("0:1", res[3]);
        }

        @Test
        public void ADUPtest3() {
            mainObj1.InState('c');
            mainObj1.InState('b');
            String[] res = mainObj1.InState('b');
            assertEquals("UPDATE", res[0]);
            assertEquals("min", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("0:2", res[3]);
        }

        @Test
        public void ADUPtest4() {
            mainObj1.InState('c');
            mainObj1.InState('b');
            mainObj1.InState('b');
            String[] res =  mainObj1.InState('a');
            assertEquals("UPDATE", res[0]);
            assertEquals("hour", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("0:2", res[3]);
        }

        @Test
        public void ADUPtest5() {
            mainObj1.InState('c');
            mainObj1.InState('b');
            mainObj1.InState('b');
            mainObj1.InState('a');
            String[] res =  mainObj1.InState('b');
            assertEquals("UPDATE", res[0]);
            assertEquals("hour", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("1:2", res[3]);
        }

        @Test
        public void ADUPtest6() {
            mainObj1.InState('c');
            mainObj1.InState('b');
            mainObj1.InState('b');
            mainObj1.InState('a');
            mainObj1.InState('b');
            String[] res = mainObj1.InState('b');
            assertEquals("UPDATE", res[0]);
            assertEquals("hour", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("2:2", res[3]);
        }

        @Test
        public void ADUPtest7() {
            mainObj1.InState('c');
            mainObj1.InState('b');
            mainObj1.InState('b');
            mainObj1.InState('a');
            mainObj1.InState('b');
            mainObj1.InState('b');
            String[] res =  mainObj1.InState('a');
            assertEquals("UPDATE", res[0]);
            assertEquals("day", res[1]);
            assertEquals("2000-1-1", res[2]);
            assertEquals("2:2", res[3]);
        }

        @Test
        public void ADUPtest8() {
            mainObj1.InState('c');
            mainObj1.InState('b');
            mainObj1.InState('b');
            mainObj1.InState('a');
            mainObj1.InState('b');
            mainObj1.InState('b');
            mainObj1.InState('a');
            String[] res =  mainObj1.InState('b');
            assertEquals("UPDATE", res[0]);
            assertEquals("day", res[1]);
            assertEquals("2000-1-2", res[2]);
            assertEquals("2:2", res[3]);
        }
    }

}