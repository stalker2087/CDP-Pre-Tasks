package by.Lushchyts.CollectionPerformanceTest;

import by.Lushchyts.CollectionPerformanceTest.MainMenu.MainMenu;

public class Launcher {

   static MainMenu menu = new MainMenu();

    public static void main(String args[]){
        while (true){
            menu.display();
            menu.selectMenuOption();
        }
    }
}
