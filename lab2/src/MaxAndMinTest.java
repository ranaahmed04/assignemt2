import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxAndMinTest {

    @Test
    public void test_Max1() throws IllegalArgumentException{
        MaxAndMin test1 = new MaxAndMin();
        int array1[] ={1,100,90,500,200,-20,-50,30};
        assertEquals(500,test1.find_Max(array1));

    }
    @Test
    public void test_Max2() throws IllegalArgumentException{
        MaxAndMin test2 = new MaxAndMin();
        int array2[] ={-1,-100,-90,-500,-200,-20,-50,-30};
        assertEquals(-1,test2.find_Max(array2));
    }
    @Test
    public void test_max3() throws IllegalArgumentException{
        MaxAndMin test3 = new MaxAndMin();
        int array3[] ={};
        assertEquals(null,test3.find_Max(array3));
    }
    @Test
    public void test_Min1() throws IllegalArgumentException{
        MaxAndMin test4 = new MaxAndMin();
        int array4[] ={1,100,90,500,200,-20,-50,30};
        assertEquals(-50,test4.find_Min(array4));
    }
    @Test
    public void test_Min2() throws IllegalArgumentException{
        MaxAndMin test5 = new MaxAndMin();
        int array5[] ={-1,-100,-90,-500,-200,-20,-50,-30};
        assertEquals(-500,test5.find_Min(array5));
    }
    @Test
    public void test_Min3() throws IllegalArgumentException{
        MaxAndMin test6 = new MaxAndMin();
        int array6[] ={};
        assertEquals(null,test6.find_Min(array6));
    }

}