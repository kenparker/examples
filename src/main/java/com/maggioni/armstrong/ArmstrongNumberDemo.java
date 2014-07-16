package com.maggioni.armstrong;

import java.util.Scanner;

/**
 * http://javarevisited.blogspot.de/2014/07/write-program-to-find-all-armstrong-number-between-0-to-9999.html
 * @author maggioni
 */
public class ArmstrongNumberDemo {

    public static void main(String args[]) {
        Scanner cmd = new Scanner(System.in);
        System.out.println("Please enter a number up-to which Armstrong number will be find");
        int count = cmd.nextInt();
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (isArmstrongNumber(i)) {
                System.out.printf("Armstrong number %d: %d %n", index, i);
                index++;
            }
        }
        cmd.close();
    }

    /**
     * * Java Method to check if given number is Armstrong Number or not * * @param number * @return true, if Armstrong
     * number, false otherwise.
     */
    public static boolean isArmstrongNumber(int number) {
        int sum = 0;
        int copyOfInput = number;
        while (copyOfInput != 0) {
            int lastDigit = copyOfInput % 10;
            sum += (lastDigit * lastDigit * lastDigit);
            copyOfInput /= 10;
        }
        if (sum == number) {
            return true;
        }
        return false;
    }

}
