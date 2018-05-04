package By.Lushchyts.laba.StringChanger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
import java.lang.NullPointerException;

public class StringChanger {

    public static FileReader reader;
    public static Scanner file, in;
    public static ArrayList<String> list = new ArrayList<String>();
    public static Logger logger = LogManager.getLogger(Level.ALL);
    public static String enteredValue;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String filePath = "c:\\Users\\Uladzimir\\IdeaProjects\\StringChanger\\src\\Text.txt";
        int key=1;
        in = new Scanner(System.in);
        try {
            readFile(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            logger.log(Level.ERROR,"File by the next way in not found: " + filePath);
            System.exit(0);
        }
        catch(NullPointerException e){
            System.out.println("File is empty!");
            logger.log(Level.ERROR, "File found by the next path is empty: " + filePath);
            System.exit(0);
        }

        while (true) {
            menu();

            try {
                key = keylistener();
            } catch (IllegalArgumentException e) {
                key = -1;
            }

            switch (key) {

                case 1:
                    sortStrings();
                    printFile();
                    logger.log(Level.INFO,"The list sorted by string length");
                    break;
                case 2:
                    sortStringsByLetters();
                    printFile();
                    logger.log(Level.INFO,"The list sorted by count of vowels");
                    break;
                case 3:
                    changeFistAndLastLetters();
                    printFile();
                    logger.log(Level.INFO,"The first and last letters of each second line changed");
                    break;
                case 4:
                    revertStrings();
                    printFile();
                    logger.log(Level.INFO,"The strings in the list reverted");
                    break;
                case 5:
                    printFile();
                    logger.log(Level.INFO,"File displayed");
                    break;
                case 0:
                    reader.close();
                    System.exit(0);
                    logger.log(Level.INFO,"Exit the program");
                    break;
                default:
                    System.out.println("Invalid operation!");
                    logger.log(Level.ERROR,"Invalid operation: "+ enteredValue);
                    break;
            }

        }

    }

    public static void menu() {
        System.out.println("");
        System.out.println("Please, select one of the available operations:");
        System.out.println("1 - Sort strings by length");
        System.out.println("2 - Sort strings by count of vowels in a line");
        System.out.println("3 - Change the first and the last character in each second line");
        System.out.println("4 - Revert strings");
        System.out.println("5 - Display strings");
        System.out.println("0 - Exit");

    }

    public static int keylistener() {

        enteredValue = in.next();
        int key = Integer.parseInt(enteredValue);
        return key;

    }

    public static void readFile(String filePath) throws FileNotFoundException {

        reader = new FileReader(filePath);
        file = new Scanner(reader);

        while (file.hasNextLine()) {

            list.add(file.nextLine());

        }
    }

    public static void printFile() {

        for (int i = 0; i < list.size(); i++) {

            System.out.format("%d. %s", i + 1, list.get(i));
            System.out.println("");
        }

    }

    public static void sortStrings() {

        String tempString;

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {

                if (list.get(j + 1).length() < list.get(j).length()) {

                    tempString = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tempString);

                }
            }
        }
    }

    public static void sortStringsByLetters() {

        String tempString;
        int currentIltem, nextItem;

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {

                currentIltem = getNumberOfVowels(list.get(j));
                nextItem = getNumberOfVowels(list.get(j + 1));

                if (currentIltem > nextItem) {

                    tempString = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tempString);

                }
            }
        }
    }

    public static int getNumberOfVowels(String string) {

        int count = 0;
        char[] newString = string.toCharArray();
        char[] wovels = "AEIOUaeiou".toCharArray();

        for (int i = 0; i < newString.length; i++) {
            for (int j = 0; j < wovels.length; j++) {

                if (newString[i] == wovels[j]) {
                    count++;

                }
            }

        }

        return count;
    }

    public static void changeFistAndLastLetters() {

        char[] tempString;
        char tmpLetter;

        for (int i = 0; i < list.size(); i++) {

            if ((i + 1) % 2 == 0) {

                tempString = list.get(i).toCharArray();
                tmpLetter = tempString[0];
                tempString[0] = tempString[tempString.length - 1];
                tempString[tempString.length - 1] = tmpLetter;
                list.set(i, String.copyValueOf(tempString));

            }

        }
    }

    public static void revertStrings() {

        char[] tempString, newString;

        for (int i = 0; i < list.size(); i++) {

            tempString = list.get(i).toCharArray();
            newString = new char[tempString.length];

            for (int j = 0; j < list.get(i).length(); j++) {
                newString[j] = tempString[tempString.length - j - 1];
            }

            list.set(i, String.valueOf(newString));
        }
    }


}
