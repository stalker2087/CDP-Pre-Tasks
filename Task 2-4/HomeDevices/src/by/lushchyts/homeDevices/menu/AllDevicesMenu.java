package by.lushchyts.homeDevices.menu;

import by.lushchyts.homeDevices.exception.SelectedOptionException;
import by.lushchyts.homeDevices.utils.KeyListener;
import by.lushchyts.homeDevices.deviceManager.DeviceManager;

public class AllDevicesMenu implements Menu {

    private DeviceManager manager;

    public AllDevicesMenu(DeviceManager manager) {
        this.manager = manager;
    }

    @Override
    public void display(){
        manager.displayAllDevices();

        System.out.println("");
        System.out.println("Press any othey key to get back");
        selectMenuOption();
    }


    @Override
    public void selectMenuOption() {

        int key;

        KeyListener enteredMenuOption = new KeyListener();

        try {
            switch (key = enteredMenuOption.getPressedKey()) {

                default:
                    System.out.println("");
                    break;

            }
        } catch (SelectedOptionException e) {

        }
    }
}
