import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class calculatorTest {

    @Test
    public void addTest(){
        calculator obj = new calculator();
        int actualResult = obj.add(1,2);
        assertEquals(3,actualResult);

    }

}