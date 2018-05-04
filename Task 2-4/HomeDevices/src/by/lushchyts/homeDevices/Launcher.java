package by.lushchyts.homeDevices;

import by.lushchyts.homeDevices.exception.SelectedOptionException;
import by.lushchyts.homeDevices.menu.MainMenu;

public class Launcher {

    private static MainMenu menu = new MainMenu();

    public static void main (String args[]) throws SelectedOptionException{
        while(true){
            menu.display();
            menu.selectMenuOption();
        }
    }
}
