package by.Lushchyts.laba.Matrixs;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.io.IOException;

public class MtrixProcessing {

    public static Scanner in = new Scanner(System.in);
    public static int[][] matrixA, matrixB, matrixC;
    public static int matrixA_rows, matrixA_columns, matrixB_rows, matrixB_columns;
    static Logger logger = LogManager.getLogger(Level.ALL);

    public static void main(String args[]) throws IOException {

        boolean is_matrixes_created;

        do {
            is_matrixes_created = initMartixs();
        } while (is_matrixes_created == false);

        while (true) {
            menu();
            keyListener();
        }
    }

    public static boolean initMartixs() {
        String enteredString = new String();
        try {
            System.out.println("Only integer numbers are allowed");
            System.out.print("Please, enter count of rows in matrix A: ");
            enteredString = in.next();
            matrixA_rows = Integer.parseInt(enteredString);
            System.out.print("Please, enter count of columns in matrix A: ");
            enteredString = in.next();
            matrixA_columns = Integer.parseInt(enteredString);
            System.out.print("Please, enter count of rows in matrix B: ");
            enteredString = in.next();
            matrixB_rows = Integer.parseInt(enteredString);
            System.out.print("Please, enter count of columns in matrix B: ");
            enteredString = in.next();
            matrixB_columns = Integer.parseInt(enteredString);
        } catch (IllegalArgumentException e) {
            System.out.println("Entered value is not a number!!!");
            logger.log(Level.ERROR, "Entered matrix dimension is incorrect: " + enteredString);
            return false;
        }

        matrixA = new int[matrixA_rows][matrixA_columns];
        matrixB = new int[matrixB_rows][matrixB_columns];

        System.out.println("Please, fill matrix A:");
        fillMatrix(matrixA);
        System.out.println("Please, fill matrix B:");
        fillMatrix(matrixB);

        return true;

    }

    public static void fillMatrix(int[][] matrix) {
        String enteredString = new String();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                try {
                    enteredString = in.next();
                    matrix[i][j] = Integer.parseInt(enteredString);
                } catch (IllegalArgumentException e) {
                    System.out.println("Entered value is not a number. Try one more time");
                    logger.log(Level.ERROR, "Entered value is not an Integer: "+ enteredString);
                    j--;
                }
            }

        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static boolean isPossibletoMultiply(int[][] matrixA, int[][] matrixB) {
        if (matrixA[0].length == matrixB.length) {
            return true;
        } else {
            return false;
        }
    }

    public static void multiplyMatrixs(int[][] A, int[][] B) {
        matrixC = new int[A.length][B[0].length];
        if (isPossibletoMultiply(A, B)) {

            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B[0].length; j++) {
                    for (int r = 0; r < A[0].length; r++) {
                        matrixC[i][j] += A[i][r] * B[r][j];
                    }
                }

            }

            printMultiplyResults();
        } else {
            System.out.format("Impossible to multiple matrix A by B. Columns count of matrix A (%d) is not equal to rows count or Matrix B (%d)", matrixB_columns, matrixA_rows);
            logger.log(Level.INFO, "Impossible to multiple matrix A by B. Columns count of matrix A (%d) is not equal to rows count or Matrix B (%d)", matrixB_columns, matrixA_rows);
        }

    }

    public static void printMultiplyResults() {
        System.out.println("Matrix A");
        printMatrix(matrixA);
        System.out.println("*");
        System.out.println("Matrix B");
        printMatrix(matrixB);
        System.out.println("=");
        System.out.println("Matrix C");
        printMatrix(matrixC);

    }

    public static void menu() {
        System.out.println("");
        System.out.println("Please, select one of the options by entering appropriate number:");
        System.out.println("1 - Multiply Matrixes");
        System.out.println("2 - Display Matrixes");
        System.out.println("3 - Re-enter Matrixes");
        System.out.println("4 - Turn Matrixes 90 degrees clockwice");
        System.out.println("5 - Turn Matrixes 90 degrees conter clockwice");
        System.out.println("6 - Transponse Matrixes");
        System.out.println("0 - exit");
    }

    public static void displayMatrixes() {
        System.out.println("Matrix A:");
        printMatrix(matrixA);
        System.out.println("Matrix B:");
        printMatrix(matrixB);
    }

    public static int[][] turnMatrix(int[][] matrix, Boolean clockwise) {
        int[][] newMatrix = new int[matrix[0].length][matrix.length];

        if (clockwise == true) {


            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    newMatrix[j][matrix.length - i - 1] = matrix[i][j];
                }
            }
        } else {

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    newMatrix[matrix[0].length - j - 1][i] = matrix[i][j];
                }
            }
        }

        return newMatrix;

    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int[][] newMatrix = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    public static void keyListener() {

        int key;
        String enteredString = new String();

        try {
            enteredString = in.next();
            key = Integer.parseInt(enteredString);
        } catch (IllegalArgumentException e) {
            key = -1;
            logger.log(Level.ERROR,"Entered operation is incorrect: " + enteredString);
        }


        switch (key) {
            case 1:
                multiplyMatrixs(matrixA, matrixB);
                logger.log(Level.INFO, "Multiplying matrixes");
                break;
            case 2:
                displayMatrixes();
                logger.log(Level.INFO, "Displaying matrixes");
                break;
            case 3:
                initMartixs();
                logger.log(Level.INFO, "Re-initializing matrixes");
                break;
            case 4:
                matrixA = turnMatrix(matrixA, true);
                matrixB = turnMatrix(matrixB, true);
                logger.log(Level.INFO, "Turning matrixes 90 degrees clockwise");
                break;
            case 5:
                matrixA = turnMatrix(matrixA, false);
                matrixB = turnMatrix(matrixB, false);
                logger.log(Level.INFO, "Turning matrixes 90 degrees conter clockwise");
                break;
            case 6:
                matrixA = transposeMatrix(matrixA);
                matrixB = transposeMatrix(matrixB);
                logger.log(Level.INFO, "Transponsing matrxes");
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Unknown operation. Please, try one more time");
                break;
        }
    }
}
