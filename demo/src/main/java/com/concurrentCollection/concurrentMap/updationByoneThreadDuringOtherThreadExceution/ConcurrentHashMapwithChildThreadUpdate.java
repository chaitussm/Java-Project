package com.concurrentCollection.concurrentMap.updationByoneThreadDuringOtherThreadExceution;

import static com.concurrentCollection.concurrentMap.updationByoneThreadDuringOtherThreadExceution.ChildBaseThread.map;

import java.util.Iterator;
import java.util.Map;

public class ConcurrentHashMapwithChildThreadUpdate {
    public static void main(String[] args) throws InterruptedException {

        map.put(100, "Shiva");
        map.put(101, "Parvathy");

        ChildBaseThread childThread = new ChildBaseThread();
        childThread.start();

        Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();

        while (itr.hasNext()) {
            Integer i1 = (Integer) itr.next().getKey();
            System.out.println("Main Thread iterating and current Entry is" + i1 + "----" + map.get(i1));
            Thread.sleep(3000); // Simulate some delay during iteration
        }

        System.out.println("Main Thread: Reading the map");
        System.out.println(map);
    }
}
