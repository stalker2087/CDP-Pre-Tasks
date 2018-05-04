package by.lushchyts.homeDevices.utils;

import java.util.Scanner;

public class InputValues {

    private Scanner in = new Scanner(System.in);
    private String enteredValue;
    private int power, minPower, maxPower;

    public String getDeviceName() {
        System.out.println("");
        System.out.println("Please, enter device name: ");
        enteredValue = in.nextLine();
        return enteredValue.trim();
    }

    public int getConsumingPower() throws IllegalArgumentException {

        do {
            System.out.println("Please, enter device power consumption: ");
            enteredValue = in.next();
            try {
                power = Integer.valueOf(enteredValue);
                if (power <= 0) {
                    throw new IllegalArgumentException("Power should be > 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please, enter a number");
                power = -1;
            }


        }

        while (power == -1);

        return power;
    }

    public int getMinPower() {
        do {
            System.out.println("");
            System.out.println("Please, enter Min value: ");
            enteredValue = in.next();
            try {
                minPower = Integer.valueOf(enteredValue);
            } catch (NumberFormatException e) {
                System.out.println("Please, enter a number");
                minPower = -1;
            }
        }

        while (minPower == -1);

        return minPower;
    }

    public int getMaxPower() {
        do {
            System.out.println("Please, enter Max value: ");
            enteredValue = in.next();
            try {
                maxPower = Integer.valueOf(enteredValue);
            } catch (NumberFormatException e) {
                System.out.println("Please, enter a number");
                maxPower = -1;
            }

            if (maxPower < minPower) {
                System.out.println("Max power should ge greater or equal to Min power");
                maxPower = -1;
            }
        }

        while (maxPower == -1);

        return maxPower;

    }
}
