package democalc;

import java.io.IOException;

public class ArabicNumber extends Numbers {
    private int a, b;
    private char symbol;

    public ArabicNumber(int a, int b, char symbol) throws IOException {

        if (rangeCheck(a, b)) {
            this.a = a;
            this.b = b;
            this.symbol = symbol;
        }else {
            throw new IOException();
        }
    }

    @Override
    public int doOperation() throws IOException {
        int result;
        switch (symbol) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                throw new IOException();
        }
        return result;
    }

    private boolean rangeCheck(int a, int b){
        return (a > 0 && a < 11) && (b > 0 && b < 11);
    }
}
