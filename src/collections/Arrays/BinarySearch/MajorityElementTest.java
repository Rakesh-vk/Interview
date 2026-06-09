package collections.Arrays.BinarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {

    @Test
    public void firstPositionTest(){
       int[] arr={1,1,1,2,2,2,2,2};
       int fp=MajorityElement.firstOccurrence(arr,2);
       assertEquals(3,fp);
    }
    @Test
    public void lastPositionTest(){
        int[] arr={1,1,1,2,2,2,2,2};
        int lp=MajorityElement.lastOccurrence(arr,2);
        assertEquals(7,lp);
    }
    @Test
    public void Testcase1(){
        int[] arr={1,1,1,2,2,2,2,2};
        int majorElement= MajorityElement.major(arr);
        assertEquals(2,majorElement);
    }

    @Test
    void basicTest() {

        int[] arr = {1,2,2,2,3};

        assertEquals(2,
                MajorityElement.major(arr));
    }

    @Test
    void noMajorityTest() {

        int[] arr = {1,1,2,2};

        assertEquals(-1,
                MajorityElement.major(arr));
    }

    @Test
    void emptyArrayTest() {

        int[] arr = {};

        assertEquals(-1,
                MajorityElement.major(arr));
    }

}