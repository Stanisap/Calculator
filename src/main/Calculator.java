package main;

import democalc.ArabicNumber;
import democalc.Manager;
import democalc.Numbers;
import democalc.RomanNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        Manager manager;
        manager = new Manager(reader.readLine());
        Numbers number = manager.getNumbers();
        if (number instanceof ArabicNumber) {
            System.out.println(number.doOperation());
        } else {
            System.out.println(((RomanNumbers) number).toRoman(number.doOperation()));
        }


    }
}
