package com.kaansonmezoz.unittesting.example1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTest {
    private static Utilities utility;

    @BeforeAll
    public static void init(){
        utility = new Utilities();
    }

    @Test
    public void everyNthChar_arrayIsNull() throws Exception{
        assertNull(utility.everyNthChar(null, 5));
    }

    @Test
    public void everyNthChar_arrayLenghthIsLessThanN() throws Exception {
        int n = 20;
        char[] charsOfString = new char[]{'h','e','l','l','o'};

        assertArrayEquals(utility.everyNthChar(charsOfString, n), charsOfString);
    }

    @ParameterizedTest
    @MethodSource("getParametersForEveryNthChar")
    public void everyNthChar(List<Character> chars, int n, List<Character> expected)throws Exception {
        char[] charArray = ListCharacterToCharArray(chars);
        char[] expectedArray = ListCharacterToCharArray(expected);

        char[] actualArray = utility.everyNthChar(charArray, n);

        assertArrayEquals(actualArray, expectedArray);
    }

    private static Stream<Arguments> getParametersForEveryNthChar(){
        return Stream.of(
                Arguments.of(Arrays.asList('h','e','l','l','o'), 2, Arrays.asList('e', 'l'))
        );
    }

    private char[] ListCharacterToCharArray(List<Character> chars){
        char[] charArray = new char[chars.size()];

        for(int i = 0; i < chars.size(); i++){
            charArray[i] = chars.get(i);
        }

        return charArray;
    }

    @ParameterizedTest
    @CsvSource({
            "AABCDDEFF, ABCDEF", "ABCCABDEEF, ABCABDEF",
            "ABCDEFF, ABCDEF", "AB88EFFG, AB8EFG",
            "112233445566, 123456", "ZYZQQB, ZYZQB", "A, A"
    })
    public void removePairs(String sourceString, String expectedString) throws Exception{
        String actualString = utility.removePairs(sourceString);

        assertEquals(expectedString, actualString);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "a", ""})
    public void removePairs_lengthLessThan2(String source) throws Exception{
        assertEquals(source, utility.removePairs(source));
    }

    @Test
    public void removePairs_nullString() throws Exception{
        assertNull(utility.removePairs(null));
    }

    @ParameterizedTest
    @ArgumentsSource(ConverterArgumentsProvider.class)
    public void converter(int firstNumber, int secondNumber, int expectedOutput) throws Exception{
        assertEquals(expectedOutput, utility.converter(firstNumber, secondNumber));
    }

    @Test
    public void converter_whenDividedByZero_throwsArithmeticException(){
        assertThrows(ArithmeticException.class, () -> {
            utility.converter(10,0);
        });
    }

    @Test
    public void returnsNullIfSizeIsOdd_shouldReturnNull() throws Exception{
        assertNull(utility.returnsNullIfSizeIsOdd("123456789"));
    }

    @Test
    public void returnsNullIfSizeIsOdd_shouldReturnFalse() throws Exception{
        String string = "12345678";

        assertNotNull(utility.returnsNullIfSizeIsOdd(string));
        assertEquals(utility.returnsNullIfSizeIsOdd(string), string);
    }
}