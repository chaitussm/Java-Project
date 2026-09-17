package com.concurrentCollection.concurrentMap.updationByoneThreadDuringOtherThreadExceution;

import static com.concurrentCollection.concurrentMap.updationByoneThreadDuringOtherThreadExceution.childBaseThread.map;

import java.util.Iterator;
import java.util.Map;

public class concurrentHashMapwithChildThreadUpdate {
    public static void main(String[] args) throws InterruptedException {

        map.put(100, "Shiva");
        map.put(101, "Parvathy");

        childBaseThread childThread = new childBaseThread();
        childThread.start();

        Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();

        while (itr.hasNext()) {
            Integer I1 = (Integer) itr.next().getKey();
            System.out.println("Main Thread iterating and current Entry is" + I1 + "----" + map.get(I1));
            Thread.sleep(3000); // Simulate some delay during iteration
        }

        System.out.println("Main Thread: Reading the map");
        System.out.println(map);
    }
}
