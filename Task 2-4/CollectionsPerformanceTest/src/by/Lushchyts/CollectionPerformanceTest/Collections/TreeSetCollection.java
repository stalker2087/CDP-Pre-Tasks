package by.Lushchyts.CollectionPerformanceTest.Collections;

import by.Lushchyts.CollectionPerformanceTest.Utils.Console;

import java.util.TreeSet;

public class TreeSetCollection extends Collections{

    public TreeSetCollection(int numberOfElements){
        super(new TreeSet<>(), numberOfElements);
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
