import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineEditorUnitTests{
    @Test
    //@Disabled("Not implemented yet")
    @DisplayName("The first test example")
    void shouldShowSimpleAssertion(){

        assertEquals(1, 1);
    }
    @Test
    @DisplayName("List test example")
    void shouldShowSimpleAssertion1(){

        List<Integer> numbers = Arrays.asList(2, 3, 5, 7);

        Assertions.assertAll(
                () -> assertEquals(2, numbers.get(0)),
                () -> assertEquals(3, numbers.get(1)),
                () -> assertEquals(5, numbers.get(2)),
                () -> assertEquals(7, numbers.get(3))
        );
//        assertEquals(2, numbers.get(0));
//        assertEquals(3, numbers.get(1));
//        assertEquals(5, numbers.get(2));
//        assertEquals(7, numbers.get(3));
    }

    @Test
    @DisplayName ("Test only if condition is met")
    void Condition(){

        Assumptions.assumeTrue(1 > 10);
        assertEquals(1, 1);
    }

    @ParameterizedTest (name = "{0}")
    @DisplayName("Parameters, testing with different numbers")
    @ValueSource(ints = {3, 4, 5, 8, 14})
    void parameters(int expectedNumberOfSides){
        int i = expectedNumberOfSides;
        assertEquals(expectedNumberOfSides, i);
    }

    @ParameterizedTest
    @DisplayName("Parameters, testing with different numbers")
    @ValueSource(ints = {0,1,2, Integer.MAX_VALUE})
    void parametersMAX(int expectedNumberOfSides){

//        int i = expectedNumberOfSides;
//        assertThrows(
//                IllegalArgumentException.class,
//                i
//        );
//        assertEquals(expectedNumberOfSides, i);
    }
    @Nested
    @DisplayName("When a shape has been created")
    class WhenShapeExists{

        //private final Shape shape = new Shape(4);

    }
}
