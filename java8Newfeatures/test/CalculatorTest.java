import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void testAdd(){

        System.out.println(new Calculator().add(20,30));
    }

}