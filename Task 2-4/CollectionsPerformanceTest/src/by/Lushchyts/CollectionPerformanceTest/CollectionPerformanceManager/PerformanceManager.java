package by.Lushchyts.CollectionPerformanceTest.CollectionPerformanceManager;

import by.Lushchyts.CollectionPerformanceTest.Collections.*;

public class PerformanceManager {

    private ArrayListCollection arrayList;
    private LinkedListCollection linkedList;
    private HasSetCollection hashSet;
    private HashMapCollection hashMap;
    private TreeSetCollection treeSet;
    private TreeMapCollection treeMap;

    public PerformanceManager(int numberOfElements){
        arrayList = new ArrayListCollection(numberOfElements);
        linkedList = new LinkedListCollection(numberOfElements);
        hashSet = new HasSetCollection(numberOfElements);
        hashMap = new HashMapCollection(numberOfElements);
        treeSet = new TreeSetCollection(numberOfElements);
        treeMap = new TreeMapCollection(numberOfElements);
    }

    public void addElementPerformanceLists(String elementName){

        printResults(arrayList.compareAddElementPerformance(elementName),linkedList.compareAddElementPerformance(elementName), "ArrayList", "LinkedList");


    }

    public void deleteElementPerformanceLists(String elementName){
        printResults(arrayList.compareDeleteElementPerformance(elementName), linkedList.compareDeleteElementPerformance(elementName), "ArrayList", "LinkedList");
    }

    public void searchForElementPerformanceLists(String elementName){
        printResults(arrayList.compareSearchElementPerformance(elementName), linkedList.compareSearchElementPerformance(elementName), "ArrayList", "LinkedList");
    }

    public void addElementPerformanceSets(String elementName){
        printResults(hashSet.compareAddElementPerformance(elementName), treeSet.compareAddElementPerformance(elementName), "HashSet", "TreeSet");
    }

    public void deleteElementPerformanceSets(String elementName){
        printResults(hashSet.compareDeleteElementPerformance(elementName), treeSet.compareDeleteElementPerformance(elementName), "HashSet", "TreeSet");
    }

    public void searchElementPerformanceSets(String elementName){
        printResults(hashSet.compareSearchElementPerformance(elementName), treeSet.compareSearchElementPerformance(elementName),"HashSet", "TreeSet");
    }

    public void addElementPerformanceMaps(String elementName, int key){
        printResults(hashMap.compareAddElementPerformance(key, elementName), treeMap.compareAddElementPerformance(key, elementName), "HashMap", "TreeMap");
    }

    public void deleteElementPerformanceMaps(int key){
        printResults(hashMap.compareDeleteElementPerformance(key), treeMap.compareDeleteElementPerformance(key), "HashMap", "TreeMap");
    }

    public void searchElementPerformanceMaps(String elementName){
        printResults(hashMap.compareSearchElementPerformance(elementName), treeMap.compareSearchElementPerformance(elementName), "HashMap", "TreeMap");
    }

    public void printResults(long time1, long time2, String collectionType1, String collectionType2){

        long result = time1-time2;

        System.out.println("");
        System.out.println(collectionType1 + " time: " + time1 + " (NanoSeconds)");
        System.out.println(collectionType2 + " time: " + time2 + " (NanoSeconds)");

        if(result>0){
            System.out.println(collectionType2 + " is faster than " + collectionType1 + " for " + (float)result/time2*100 + " %" );
        }

        if(result<0){
            System.out.println(collectionType1 + " is faster than " + collectionType2 + " for " + (float)Math.abs(result)/time1*100 + " %" );
        }

        if(result == 0) {
            System.out.println(collectionType1 + " has  the same performance as " + collectionType2);
        }
    }
}
