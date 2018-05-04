package by.Lushchyts.CollectionPerformanceTest.MainMenu;

import by.Lushchyts.CollectionPerformanceTest.Utils.Console;
import by.Lushchyts.CollectionPerformanceTest.CollectionPerformanceManager.PerformanceManager;

public class MainMenu {

    private Console console = new Console();
    private PerformanceManager collections = new PerformanceManager(console.getNumber());


    public void display() {

        System.out.println("");
        System.out.println("Please, select one of the options below:");
        System.out.println("1 - ArrayList vs LinkedList");
        System.out.println("2 - HashSet vs TreeSet");
        System.out.println("3 - HashMap vs TreeMap");
        System.out.println("0 - exit");
    }

    public void selectMenuOption() {

        int key = console.getPressedKey();
        int secondKEy;

        switch (key) {
            case 1:
                secondLevelMenu();
                secondKEy = console.getPressedKey();

                switch (secondKEy) {
                    case 1:
                        collections.addElementPerformanceLists(console.getElementName());
                        break;
                    case 2:
                        collections.deleteElementPerformanceLists(console.getElementName());
                        break;
                    case 3:
                        collections.searchForElementPerformanceLists(console.getElementName());
                        break;
                    default:
                        System.out.println("Unknown option");
                        break;
                }

                break;
            case 2:
                secondLevelMenu();
                secondKEy = console.getPressedKey();

                switch (secondKEy) {
                    case 1:
                        collections.addElementPerformanceSets(console.getElementName());
                        break;
                    case 2:
                        collections.deleteElementPerformanceSets(console.getElementName());
                        break;
                    case 3:
                        collections.searchElementPerformanceSets(console.getElementName());
                        break;
                    default:
                        System.out.println("Unknown option");
                        break;
                }
                break;
            case 3:
                secondLevelMenu();
                secondKEy = console.getPressedKey();

                switch (secondKEy) {
                    case 1:
                        collections.addElementPerformanceMaps(console.getElementName(), console.getElementKey());
                        break;
                    case 2:
                        collections.deleteElementPerformanceMaps(console.getElementKey());
                        break;
                    case 3:
                        collections.searchElementPerformanceMaps(console.getElementName());
                        break;
                    default:
                        System.out.println("Unknown option");
                        break;

                }
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Unknown option");
                break;
        }
    }

    public void secondLevelMenu() {
        System.out.println("");
        System.out.println("Please, select one of the options below:");
        System.out.println("1 - Add element");
        System.out.println("2 - Delete element");
        System.out.println("3 - Search for element");
    }
}
