package task3;

/*
    Task3
    Реализовать функцию нечеткого поиска
        fuzzySearch("car", "ca6$$#_rtwheel"); // true
        fuzzySearch("cwhl", "cartwheel"); // true
        fuzzySearch("cwhee", "cartwheel"); // true
        fuzzySearch("cartwheel", "cartwheel"); // true
        fuzzySearch("cwheeel", "cartwheel"); // false
        fuzzySearch("lw", "cartwheel"); // false
*/


import org.junit.Assert;
import org.junit.Test;

public class Main {
    public static void main(String[] args) {
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));
        System.out.println(fuzzySearch("cwhl", "cartwheel"));
        System.out.println(fuzzySearch("cwhee", "cartwheel"));
        System.out.println(fuzzySearch("cartwheel", "cartwheel"));
        System.out.println(fuzzySearch("cwheeel", "cartwheel"));
        System.out.println(fuzzySearch("lw", "cartwheel"));
    }

    private static boolean fuzzySearch(String line, String errorLine) {
        if (line.isEmpty() || errorLine.isEmpty()) {
            return false;
        }
        int charIndex = 0;
        int charIndex2 = 0;
        while (charIndex2 < errorLine.length()) {
            if (charIndex == line.length() - 1) return true;
            if (line.charAt(charIndex) == errorLine.charAt(charIndex2)) {
                charIndex++;
            }
            charIndex2++;
        }
        return false;
    }

    @Test
    public void fuzzySearchTests() {
        Assert.assertTrue(fuzzySearch("qwert", "qbnkwb,nekjnrb vhkt"));
        Assert.assertFalse(fuzzySearch("car", "racvgfd"));
    }
}


