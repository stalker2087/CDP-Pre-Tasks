package by.Lushchyts.CollectionPerformanceTest.Collections;

import java.util.Collection;
import by.Lushchyts.CollectionPerformanceTest.Utils.FillCollection;
import by.Lushchyts.CollectionPerformanceTest.Utils.Console;
public class Collections {

    Collection collection;

    public Collections(Collection collection, int numberOfElements){
        this.collection = collection;
        FillCollection collectionUtil = new FillCollection();
        Console console = new Console();
        collectionUtil.fillCollection(numberOfElements,collection);
    }

    public void addElement(Object element){

        collection.add(element);
    }

    public void deleteElement(Object element){
        if(collection.remove(element)==true){
            System.out.println("Element deleted");
        }

        else{
            System.out.println("Element does not exist");
        }
    }

    public void searchForElement(Object element){
        if(collection.contains(element)==true){
            System.out.println("Element found");
        }

        else{
            System.out.println("Element does not exist");
        }
    }

    public long compareAddElementPerformance(Object element){
        long startTime = System.nanoTime();
        addElement(element);
        long endTime = System.nanoTime();

        long result = endTime - startTime;

        return result;

    }

    public long compareDeleteElementPerformance(Object element){
        long startTime = System.nanoTime();
        deleteElement(element);
        long endTime = System.nanoTime();

        long result = endTime - startTime;

        return result;

    }

    public long compareSearchElementPerformance(Object element){
        long startTime = System.nanoTime();
        searchForElement(element);
        long endTime = System.nanoTime();

        long result = endTime - startTime;

        return result;

    }


   /* void addElement(Object element);
    boolean searchForElement(Object element);
    void deleteElement(Object element);
    long compareAddElementPerformance(Object element);
    long compareDeleteElementPerformance(Object element);
    long compareSearchElementPerformance(Object element);*/

}
