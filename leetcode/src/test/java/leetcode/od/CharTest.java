package leetcode.od;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CharTest {

    @Test
    public void charToInt() {
        assertEquals(Integer.valueOf('1'), 49);
        assertEquals(Integer.valueOf("1"), 1);
    }

    @Test
    public void intToChar() {
        assertEquals('A', (char) 65);
        assertEquals('A', 65);
        // "A" "65"
        assertNotEquals(String.valueOf('A'), String.valueOf(65));
    }

    @Test
    public void charEscape(){
        System.out.println("\\.");
        System.out.println("\"");
    }
}
