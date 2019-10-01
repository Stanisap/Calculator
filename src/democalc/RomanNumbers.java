package democalc;

import java.io.IOException;
import java.util.Map;

public class RomanNumbers extends Numbers {
    private String a, b;
    private char symbol;

    public RomanNumbers(String a, String b, char symbol) {
        this.a = a;
        this.b = b;
        this.symbol = symbol;
    }

    public static String repeat(String roman, int ranch) {
        if (roman == null) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ranch; i++) {
            sb.append(roman);
        }
        return sb.toString();
    }

    public String toRoman(int arabic) {
        StringBuilder result = new StringBuilder();
        if (arabic < 0) {
            result.append("-");
            arabic = Math.abs(arabic);
        }

        for (Map.Entry<String, Integer> entry : creatMap().entrySet()) {
            int matches = arabic / entry.getValue();
            result.append(repeat(entry.getKey(), matches));
            arabic = arabic % entry.getValue();
        }
        return result.toString();
    }

    public int toArabic(String roman) {
        String romanNumeral = roman.toUpperCase();
        int result = 0;
        for (int i = 0; i < roman.length(); i++) {
            for (Map.Entry<String, Integer> entry : creatMap().entrySet()) {
                if (romanNumeral.startsWith(entry.getKey())) {
                    result += entry.getValue();
                    romanNumeral = romanNumeral.substring(entry.getKey().length());
                }
            }
        }
        if (romanNumeral.length() > 0) throw new IllegalArgumentException();
        return result;
    }

    @Override
    public int doOperation() throws IOException {
        int c = toArabic(this.a);
        int d = toArabic(this.b);
        ArabicNumber arabicNumber = new ArabicNumber(c, d, this.symbol);

        return arabicNumber.doOperation();
    }


}
