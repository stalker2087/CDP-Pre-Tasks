package by.Lushchyts.CollectionPerformanceTest.Collections;

import java.util.HashSet;

public class HasSetCollection extends Collections{

    public HasSetCollection(int numberOfElements){
        super(new HashSet(), numberOfElements);
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
