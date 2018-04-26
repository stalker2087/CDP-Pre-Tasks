package by.lushchyts.homeDevices.menu;

import by.lushchyts.homeDevices.utils.Reader;
import java.io.FileNotFoundException;
import java.io.IOException;
import by.lushchyts.homeDevices.deviceManager.DeviceManager;

public class ReadFileMenu {

    String refregeratorsFile = "c:\\Users\\Uladzimir\\IdeaProjects\\HomeDevices\\src\\files\\Refregerators.txt";
    String tvSetsFile = "c:\\Users\\Uladzimir\\IdeaProjects\\HomeDevices\\src\\files\\TVs.txt";
    String conditionersFile = "c:\\Users\\Uladzimir\\IdeaProjects\\HomeDevices\\src\\files\\Conditioners.txt";
    String kitchenDevicesFile = "c:\\Users\\Uladzimir\\IdeaProjects\\HomeDevices\\src\\files\\KitchenDevices.txt";
    String otherDevicesFile = "c:\\Users\\Uladzimir\\IdeaProjects\\HomeDevices\\src\\files\\OtherDevices.txt";


    private DeviceManager manager;
    private Reader reader;

    public ReadFileMenu(DeviceManager manager){
        this.manager = manager;
        reader = new Reader(this.manager);
    }



public void readFiles(){
    try {
        reader.readFile(refregeratorsFile, 1);
        reader.readFile(tvSetsFile, 2);
        reader.readFile(conditionersFile, 3);
        reader.readFile(kitchenDevicesFile, 4);
        reader.readFile(otherDevicesFile, 5);
    }catch(FileNotFoundException e){
        System.out.println("");
        System.out.println(e.getMessage());
        System.out.println("");
    }

}

public void writeFiles(){
    try {
        reader.writeFile(refregeratorsFile, 1);
        reader.writeFile(tvSetsFile, 2);
        reader.writeFile(conditionersFile, 3);
        reader.writeFile(kitchenDevicesFile, 4);
        reader.writeFile(otherDevicesFile, 5);
    }catch(IOException e){
        System.out.println("");
        System.out.println(e.getMessage());
        System.out.println("");
    }
}
}
