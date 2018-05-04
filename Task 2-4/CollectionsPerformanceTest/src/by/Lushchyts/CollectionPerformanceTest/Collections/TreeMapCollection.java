package by.Lushchyts.CollectionPerformanceTest.Collections;

import java.util.TreeMap;
import by.Lushchyts.CollectionPerformanceTest.Utils.FillCollection;

public class TreeMapCollection{

    private TreeMap<Integer, String> map;

    public TreeMapCollection(int numberOfElements){
        map = new TreeMap<>();
        FillCollection CollectionUtil = new FillCollection();
        CollectionUtil.fillTreeMap(numberOfElements, map);
    }

    public void addElement(int number, String element){
        map.put(number, element);
    }

    public void deleteElement(int key){
        if(map.remove(key)==null){
            System.out.println("Element Does not exist");
        } else {
            System.out.println("Element deleted");
        }
    }

    public void searchForElement(String elementName){
        if(map.containsValue(elementName)==true){
            System.out.println("Element found");
        }
        else {
            System.out.println("Element does not exist");
        }
    }

    public long compareAddElementPerformance(int number, String element){
        long startTime = System.nanoTime();
        addElement(number, element);
        long endTime = System.nanoTime();

        long result = endTime - startTime;

        return result;

    }

    public long compareDeleteElementPerformance(int number){
        long startTime = System.nanoTime();
        deleteElement(number);
        long endTime = System.nanoTime();

        long result = endTime - startTime;

        return result;

    }

    public long compareSearchElementPerformance(String elementName){
        long startTime = System.nanoTime();
        searchForElement(elementName);
        long endTime = System.nanoTime();

        long result = endTime - startTime;

        return result;

    }
}
