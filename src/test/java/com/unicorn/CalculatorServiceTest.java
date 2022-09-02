import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {


    @Mock
    Calculator calculator;

    @InjectMocks
    private CalculatorService service;

    @BeforeEach
    void setUp() {
        //service = new CalculatorService(calculator);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAdd() {

        // setup
        when(calculator.add(2,2)).thenReturn(4);
        int expected = 4;

        // exercise
        int actual = service.execute("add",2,2);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void testAddMultiple() {

        // setup
        when(calculator.add(2,2, 2)).thenReturn(6);
        int expected = 6;

        // exercise
        int actual = service.execute("add",2,2, 2);

        // assert
        assertEquals(expected, actual);

    }

    @Test
    public void testSubtract() {

        when(calculator.subtract(2,2)).thenReturn(0);

        int expected = 0;
        int actual = service.execute("subtract",2,2);
        assertEquals(expected, actual);

    }

    @Test
    public void testMultiply() {

        when(calculator.multiply(2,2)).thenReturn(4);

        int expected = 4;
        int actual = service.execute("multiply",2,2);
        assertEquals(expected, actual);

    }

    @Test
    public void testDivide() {

        when(calculator.divide(2,2)).thenReturn(1);

        int expected = 1;
        int actual = service.execute("divide",2,2);
        assertEquals(expected, actual);

    }

    @Test
    public void testDivideByZero() {

        when(calculator.divide(0,0)).thenThrow(ArithmeticException.class);

        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(0,0);
        });

    }

    @Test
    public void testIllegalArgumentException1() {

        assertThrows(IllegalArgumentException.class, () -> {
            service.execute("what?", 2 , 2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            service.execute("what?", 2 , 2, 2);
        });
    }


}