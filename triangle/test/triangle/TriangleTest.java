package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

/**
 * Test class for the Triangle implementation.
 */
public class TriangleTest {

    @Test
    public void test1() {
        Type actual = Triangle.classify(10, 10, 10);
        Type expected = EQUILATERAL;
        assertEquals(actual, expected);
    }

    @Test
    public void statementCoverage() {
        Type actual = Triangle.classify(-10, 10, 10);
        Type expected = INVALID;
        assertEquals("Line 21 statement", expected, actual);

        // Trian = 6
        actual = Triangle.classify(10, 10, 10);
        expected = EQUILATERAL;
        assertEquals("Line 24-32 statement", expected, actual);

        // Trian = 0
        actual = Triangle.classify(10, 20, 30);
        expected = INVALID;
        assertEquals(expected, actual);

        // Trian = 0
        actual = Triangle.classify(10, 15, 20);
        expected = SCALENE;
        assertEquals(expected, actual);

        // Trian = 1
        actual = Triangle.classify(10, 10, 15);
        expected = ISOSCELES;
        assertEquals(expected, actual);

        // Trian = 2
        actual = Triangle.classify(10, 15, 10);
        expected = ISOSCELES;
        assertEquals(expected, actual);

        // Trian = 2
        actual = Triangle.classify(15, 10, 10);
        expected = ISOSCELES;
        assertEquals(expected, actual);

        // Throw Exception
        actual = Triangle.classify(15, 5, 5);
        expected = INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void decisionCoverage() {
        // line 20-22
        Type actual = Triangle.classify(-10, 10, 10);
        Type expected = INVALID;
        assertEquals(expected, actual);
        actual = Triangle.classify(10, 10, 10);
        expected = INVALID;
        assertNotEquals(expected, actual);

        // line 24-32
        actual = Triangle.classify(10, 10, 10);
        expected = EQUILATERAL;
        assertEquals(expected, actual);
        actual = Triangle.classify(10, 20, 30);
        expected = INVALID;
        assertEquals(expected, actual);

        // line 33-39
        actual = Triangle.classify(10, 20, 30);
        expected = INVALID;
        assertEquals(expected, actual);
        actual = Triangle.classify(10, 25, 30);
        expected = SCALENE;
        assertEquals(expected, actual);

        // line 40-42
        actual = Triangle.classify(10, 10, 10);
        expected = EQUILATERAL;
        assertEquals(expected, actual);
        actual = Triangle.classify(10, 20, 30);
        expected = EQUILATERAL;
        assertNotEquals(expected, actual);

        // line 43-44
        actual = Triangle.classify(10, 10, 15);
        expected = ISOSCELES;
        assertEquals(expected, actual);
        actual = Triangle.classify(10, 10, 30);
        expected = ISOSCELES;
        assertNotEquals(expected, actual);

        // line 45-46
        actual = Triangle.classify(10, 15, 10);
        expected = ISOSCELES;
        assertEquals(expected, actual);
        actual = Triangle.classify(10, 30, 10);
        expected = ISOSCELES;
        assertNotEquals(expected, actual);

        // line 47-49
        actual = Triangle.classify(15, 10, 10);
        expected = ISOSCELES;
        assertEquals(expected, actual);
        actual = Triangle.classify(30, 10, 10);
        expected = ISOSCELES;
        assertNotEquals(expected, actual);
    }

    @Test
    public void ConditionCoverage() {
        // line 20-22
        Type actual = Triangle.classify(-10, -10, -10);
        Type expected = INVALID;
        assertEquals(expected, actual);
        actual = Triangle.classify(10, 10, 10);
        expected = INVALID;
        assertNotEquals(expected, actual);

        // line 24-32
        actual = Triangle.classify(10, 10, 10);
        expected = EQUILATERAL;
        assertEquals(expected, actual);
        actual = Triangle.classify(10, 20, 30);
        expected = INVALID;
        assertEquals(expected, actual);

        // line 33
        actual = Triangle.classify(10, 10, 10); 
        expected = INVALID;
        assertNotEquals("line 33: False", expected, actual);
        expected = SCALENE;
        assertNotEquals("line 33: False", expected, actual);
        actual = Triangle.classify(10, 20, 30);
        expected = SCALENE;
        assertEquals(expected, actual);
    }
}
