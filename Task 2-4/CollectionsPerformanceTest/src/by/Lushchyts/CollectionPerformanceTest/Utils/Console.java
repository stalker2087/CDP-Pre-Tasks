package by.Lushchyts.CollectionPerformanceTest.Utils;

import java.util.Scanner;

public class Console {

    private String enteredValue;
    private int key;
    private Scanner in;

    public Console() {
        in = new Scanner(System.in);
    }


    public int getPressedKey() {
        if (in.hasNext()) {
            enteredValue = in.nextLine();
            try {
                key = Integer.valueOf(enteredValue);
            } catch (NumberFormatException e) {
                System.out.println("");
                return key = -1;
            }
            return key;
        }

        System.out.println("");
        return -1;

    }

    public int getNumber() {
        int number;

        do {
            System.out.println("Please, enter number of elements in the collection: ");
            enteredValue = in.nextLine();
            try {
                number = Integer.valueOf(enteredValue);
            } catch (NumberFormatException e) {
                System.out.println("Please, enter a number");
                number = -1;
            }

            if (number <= 0) {
                number = -1;
                System.out.println("Number should be greater than 0");
            }
        }

        while (number == -1);

        return number;
    }

    public String getElementName() {
        System.out.println("Please, enter element Name: ");

        return in.nextLine().trim();
    }

    public int getElementKey() {


        int number;

        do {
            System.out.println("Please, enter key of the element in collection: ");
            enteredValue = in.nextLine();
            try {
                number = Integer.valueOf(enteredValue);
            } catch (NumberFormatException e) {
                System.out.println("Please, enter a number");
                number = -1;
            }
        }

        while (number == -1);

        return number;
    }
}
