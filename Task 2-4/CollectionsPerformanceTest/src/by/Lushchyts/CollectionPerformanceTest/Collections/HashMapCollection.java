package by.Lushchyts.CollectionPerformanceTest.Collections;

import by.Lushchyts.CollectionPerformanceTest.Utils.FillCollection;

import java.util.HashMap;

public class HashMapCollection {

    private HashMap map;

    public HashMapCollection(int numberOfElements){
        map = new HashMap();
        FillCollection CollectionUtil = new FillCollection();
        CollectionUtil.fillHashMap(numberOfElements, map);
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
        } else {
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
