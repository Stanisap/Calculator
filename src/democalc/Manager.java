package democalc;

import java.io.IOException;

public class Manager {
    private String string;
    private int[] intNumbers;

    public Manager(String string) {
        this.string = string;
    }

    public Numbers getNumbers() throws IOException {
        char ch = ' ';
        int index;
        String[] arr = new String[2];
        if ((index = string.indexOf('+')) > 0) {
            ch = string.charAt(index);
            arr = string.split("\\+");
        }
        if ((index = string.indexOf('-')) > 0) {
            ch = string.charAt(index);
            arr = string.split("-");
        }
        if ((index = string.indexOf('*')) > 0) {
            ch = string.charAt(index);
            arr = string.split("\\*");
        }
        if ((index = string.indexOf('/')) > 0) {
            ch = string.charAt(index);
            arr = string.split("/");
        }
        Numbers numbers;
        if (getNum(arr)) numbers = new ArabicNumber(intNumbers[0], intNumbers[1], ch);
        else numbers = new RomanNumbers(arr[0].trim(), arr[1].trim(), ch);
        return numbers;
    }

    private boolean getNum(String[] strings) {
        intNumbers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i].trim();
            if (s.matches("[\\d]+")) intNumbers[i] = Integer.parseInt(s);
            else return false;
        }
        return true;
    }
}
