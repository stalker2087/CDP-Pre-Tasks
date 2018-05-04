package by.Lushchyts.CollectionPerformanceTest.Collections;

import java.util.LinkedList;

public class LinkedListCollection extends Collections {


    public LinkedListCollection(int numberOfElements){
        super(new LinkedList(),numberOfElements);
    }

    public void addElement(Object element){
        super.addElement(element);
    }

    public void deleteElement(Object element){
        super.deleteElement(element);
    }

    public void searchForElement(Object element){
         super.searchForElement(element);
    }

    public long compareAddElementPerformance(Object element){
        return super.compareAddElementPerformance(element);

    }

    public long compareDeleteElementPerformance(Object element){
        return super.compareDeleteElementPerformance(element);
    }

    public long compareSearchElementPerformance(Object element){
        return super.compareSearchElementPerformance(element);
    }

}
