package com.Lushchyts.calculator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import java.lang.IllegalArgumentException;
import java.util.Scanner;

import org.apache.logging.log4j.Logger;
import com.Lushchyts.calculator.DivideByZeroExcption;
import org.apache.logging.log4j.core.config.plugins.convert.TypeConverters;

public class ConsoleCalculator {


    public static Scanner in = new Scanner(System.in);
    static Logger logger_err = LogManager.getLogger(Level.ALL);


    public static void main(String[] args) throws DivideByZeroExcption {

        System.out.println("Calculator is running.");
        double firstNumber = 0, secondNumber = 0, result = 0;
        char operation;
        int key = keyListener();

        while (key != 0) {

            switch (key) {
                case 1:
                    try {
                        firstNumber = getOperands();
                        operation = getOperation();
                        secondNumber = getOperands();
                    } catch (NumberFormatException e) {
                        System.out.println("Entered value is not a number: " + e);
                        logger_err.log(Level.ERROR, e);
                        break;
                    }
                    try {
                        result = calculate(firstNumber, secondNumber, operation);
                    } catch (IllegalArgumentException e) {
                        logger_err.log(Level.ERROR, e);
                        System.out.println("Invalid operation: " + operation);
                        break;
                    } catch (DivideByZeroExcption e) {
                        logger_err.log(Level.ERROR, e);
                        System.out.println("Dividing by zero: " +  firstNumber + " / " + secondNumber);
                        break;
                    }

                    publishResult(firstNumber, secondNumber, operation, result);
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
            }

            key = keyListener();

        }


    }


    public static void menu() throws DivideByZeroExcption {
        System.out.println("");
        System.out.println("Please, select one of the available options: ");
        System.out.println("0 - exit");
        System.out.println("1 - calculate");


    }

    public static int keyListener() throws DivideByZeroExcption {

        String s = "";
        int key = 0;

        menu();

        try {
            s = in.next();
            key = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            logger_err.log(Level.ERROR, "Unknown menu option: " + s);
            System.out.println("Unknown menu option: " + s);
            return -1;
        }
        return key;

    }

    public static double getOperands() throws DivideByZeroExcption {

        String s = new String();
        double a = 0;
        System.out.print("Enter a number: ");

        s = in.next();
        a = Double.valueOf(s);

        return a;
    }

    public static char getOperation() {

        String s;
        System.out.print("Enter an operation: ");
        s = in.next();
        char c = s.charAt(0);
        return c;
    }

    public static String handleNumber(double a) {

        String s = Double.toString(a);
        return s.replaceAll("\\.?0*$", "");
    }

    public static double calculate(double a, double b, char operation) throws IllegalArgumentException, DivideByZeroExcption {

        double result;

        switch (operation) {
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
                if (b == 0) {
                    throw new DivideByZeroExcption(" Dividing by zero: " + Double.toString(a) + " / " + Double.toString(b));
                }
                result = a / b;
                break;

            default:
                throw new IllegalArgumentException("Invalid operatin: " + Character.toString(operation));

        }

        return result;
    }

    public static void publishResult(double a, double b, char operation, double result) {

        String result2 = handleNumber(a) + " " + operation + " " + handleNumber(b) + " = " + handleNumber(result);
        System.out.println(result2);
        logger_err.log(Level.INFO, result2);

    }

}