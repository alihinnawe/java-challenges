import java.util.ArrayList;
import java.util.List;
//xmas
public class TripleDouble {

    public static int tripledouble(int num1, int num2) {
        List<Character> tripleDigits = getTripleDigits(num1);
        String num2Str = Integer.toString(num2);

        for (char digit : tripleDigits) {
            if (num2Str.contains("" + digit + digit)) {
                return 1;
            }
        }

        return 0;
    }

    private static List<Character> getTripleDigits(int num) {
        List<Character> tripleDigits = new ArrayList<>();
        String numStr = Integer.toString(num);
        int count = 1;

        for (int i = 1; i < numStr.length(); i++) {
            if (numStr.charAt(i) == numStr.charAt(i - 1)) {
                count++;
                if (count == 3) {
                    tripleDigits.add(numStr.charAt(i));
                }
            } else {
                count = 1;
            }
        }

        return tripleDigits;
    }

    public static void main(String[] args) {
        System.out.println(tripledouble(451999277, 41177722899));
        System.out.println(tripledouble(1222345, 12345));
    }
}
