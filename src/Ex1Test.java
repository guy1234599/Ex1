import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }}

    @Test
    public void testIsNumber() {
        // מספרים תקינים
        assertTrue(Ex1.isNumber("123"));
        assertTrue(Ex1.isNumber("-123"));
        assertTrue(Ex1.isNumber("101b2")); // מספר בבסיס 2
        assertTrue(Ex1.isNumber("F3b16")); // מספר בבסיס 16

        // קלטים לא חוקיים

        assertFalse(Ex1.isNumber("12b17")); // בסיס מחוץ לטווח
        assertFalse(Ex1.isNumber("FbF")); // בסיס מחוץ לטווח
        assertFalse(Ex1.isNumber("12b")); // חסר בסיס
        assertFalse(Ex1.isNumber("b10")); // חסר מספר
        assertFalse(Ex1.isNumber("10bb2")); // יותר מ-"b" אחת
        assertFalse(Ex1.isNumber("123a")); // תו לא חוקי
        assertFalse(Ex1.isNumber(null));
        assertFalse(Ex1.isNumber(""));
    }

    @Test
    public void testNumber2Int() {
        // מספרים תקינים
        assertEquals(123, Ex1.number2Int("123"));
        assertEquals(1011 , Ex1.number2Int("1111110011b2"));
        assertEquals(-1, Ex1.number2Int("12b17")); // בסיס לא תקין
        assertEquals(5, Ex1.number2Int("101b2")); // מספר בבסיס 2
        assertEquals(255, Ex1.number2Int("FFb16")); // מספר גדול בבסיס 16

        // קלטים לא חוקיים
        assertEquals(-1, Ex1.number2Int("b10")); // חסר מספר
        assertEquals(-1, Ex1.number2Int("123a")); // תו לא חוקי
        assertEquals(-1, Ex1.number2Int(null));
        assertEquals(-1, Ex1.number2Int(""));
    }

    @Test
    public void testInt2Number() {
        // מספרים תקינים
        assertEquals("111b2", Ex1.int2Number(7, 2)); // מספר 7 בבסיס 2
        assertEquals("7b10", Ex1.int2Number(7, 10)); // מספר 7 בבסיס 10
        assertEquals("F3b16", Ex1.int2Number(243, 16)); // מספר 243 בבסיס 16
        assertEquals("0b2", Ex1.int2Number(0, 2)); // מספר אפס

        // קלטים לא חוקיים
        assertEquals("", Ex1.int2Number(-1, 10)); // מספר שלילי
        assertEquals("", Ex1.int2Number(10, 17)); // בסיס לא תקין
        assertEquals("", Ex1.int2Number(10, 1)); // בסיס מתחת ל-2
    }

    @Test
    public void testAdd() {
        // חיבור תקין
        assertEquals("110b2", Ex1.add("101b2", "1b2", 2)); // 5+1 בבסיס 2
        assertEquals("8b10", Ex1.add("5", "3", 10)); // 5+3 בבסיס 10
        assertEquals("102b10", Ex1.add("99b10", "3b10", 10)); // חיבור גדול

        }

    @Test
    public void testMultiply() {
        // כפל תקין
        assertEquals("1001b2", Ex1.multiply("11b2", "11b2", 2)); // 3*3 בבסיס 2
        assertEquals("15b10", Ex1.multiply("5", "3", 10)); // 5*3 בבסיס 10
    }

    @Test
    public void testEquals() {
        // מחרוזות שוות
        assertTrue(Ex1.equals("123", "123"));
        assertTrue(Ex1.equals("", ""));

        // מחרוזות שונות
        assertFalse(Ex1.equals("123", "124"));
        assertFalse(Ex1.equals("123", "1234"));
        assertFalse(Ex1.equals("abc", "def"));

        // קלטים לא חוקיים
        assertFalse(Ex1.equals(null, "123"));
        assertFalse(Ex1.equals("123", null));
    }

    @Test
    public void testMaxIndex() {
        // בסיס לחישוב תוצאה
        int base = 2;

        // מערך עם ארבעה ערכים: שני מספרים עשרוניים, תוצאת חיבור בבסיס, ותוצאת כפל בבסיס
        String[] numbers = {"5", "3", Ex1.add("5", "3", base), Ex1.multiply("5", "3", base)};
        assertEquals(15, Ex1.maxIndex(numbers)); // המספר הגדול ביותר הוא 15 (5 * 3 בבסיס 10)

        // מערך עם מספרים אחרים
        numbers = new String[]{"7", "2", Ex1.add("7", "2", base), Ex1.multiply("7", "2", base)};
        assertEquals(14, Ex1.maxIndex(numbers)); // המספר הגדול ביותר הוא 14 (7 * 2 בבסיס 10)

        // תרחיש נוסף עם בסיס שונה (16)
        base = 16;
        numbers = new String[]{"10", "5", Ex1.add("10", "5", base), Ex1.multiply("10", "5", base)};
        assertEquals(50, Ex1.maxIndex(numbers)); // המספר הגדול ביותר הוא 80 (10 * 5 בבסיס 10)

        // מערך עם תוצאה קטנה
        numbers = new String[]{"1", "1", Ex1.add("1", "1", base), Ex1.multiply("1", "1", base)};
        assertEquals(2, Ex1.maxIndex(numbers)); // המספר הגדול ביותר הוא 2 (1 + 1 בבסיס 10)

    }

}
