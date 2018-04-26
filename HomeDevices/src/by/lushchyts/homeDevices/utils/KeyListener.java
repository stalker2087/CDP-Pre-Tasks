package by.lushchyts.homeDevices.utils;

import by.lushchyts.homeDevices.exception.SelectedOptionException;

import java.util.Scanner;

public class KeyListener {

    private String enteredValue;
    private int key;
    private Scanner in;

    public KeyListener() {
        in = new Scanner(System.in);
    }


    public int getPressedKey() throws SelectedOptionException{
        if (in.hasNext()) {
            enteredValue = in.next();
            try {
                key = Integer.valueOf(enteredValue);
            } catch (NumberFormatException e) {
                System.out.println("");
                throw new SelectedOptionException( enteredValue + " is not an option");
            }
            return key;
        }

        System.out.println("");
        return -1;

    }


}
