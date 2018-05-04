package by.Lushchyts.CollectionPerformanceTest.Utils;

import java.util.Collection;
import java.util.TreeMap;
import java.util.HashMap;

public class FillCollection {
    public void fillCollection(int numberOfElements, Collection collection){
        for(int i=0; i<numberOfElements;i++){
            collection.add("Line " + i+1);
        }
    }

    public void fillTreeMap(int numberOfElements, TreeMap map){
        for(int i=0; i<numberOfElements;i++){
            map.put(i, "Line");
        }
    }

    public void fillHashMap(int numberOfElements, HashMap map){
        for(int i=0; i<numberOfElements;i++){
            map.put(i, "Line");
        }
    }

}
