import org.junit.Test;

import static org.junit.Assert.*;

public class TestingTest {
    Testing testing=new Testing();


    @Test
    public void testSC() {

    }

    @Test
    public void avgSC() {
        int[] arr=new int[]{100,200,300,400,500};
       System.out.println(testing.avgSC(arr));
    }
}