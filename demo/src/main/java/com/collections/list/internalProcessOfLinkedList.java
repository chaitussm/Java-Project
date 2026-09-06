package com.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class internalProcessOfLinkedList {

    public void demonstrateDoublyLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();

        // insert at the end
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println("List: " + list);

        // traverse forward
        Iterator<Integer> forward = list.iterator();
        System.out.print("Forward: ");
        while (forward.hasNext()) {
            System.out.print(forward.next() + " ");
        }
        System.out.println();

        // traverse backward using ListIterator
        ListIterator<Integer> backward = list.listIterator(list.size());
        System.out.print("Backward: ");
        while (backward.hasPrevious()) {
            System.out.print(backward.previous() + " ");
        }
        System.out.println();

        // delete the middle node (value 20)
        list.remove(Integer.valueOf(20));
        System.out.println("After removing 20: " + list);
    }

    // shows why removing a known node in LinkedList is O(1): only 2 pointer updates, no shifting
    private void explainConstantTimeRemoval() {
        LinkedList<String> list = new LinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        ListIterator<String> it = list.listIterator();
        it.next(); // A
        it.next(); // B, cursor now sits right after B, holding direct references to B's neighbors
        it.remove(); // unlinks B: A.next = C, C.prev = A -- no shifting of remaining elements
        System.out.println("After ListIterator.remove(): " + list);
    }

    // middle insertion/deletion benchmark: LinkedList avoids the shifting cost ArrayList pays
    private void benchmarkMiddleInsertAndDelete(int elementCount) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < elementCount; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
        int midIndex = elementCount / 2;

        long arrayInsertStart = System.nanoTime();
        arrayList.add(midIndex, -1); // shifts every element after midIndex by one position
        long arrayInsertTime = System.nanoTime() - arrayInsertStart;

        long arrayRemoveStart = System.nanoTime();
        arrayList.remove(midIndex); // shifts every element after midIndex back by one position
        long arrayRemoveTime = System.nanoTime() - arrayRemoveStart;

        ListIterator<Integer> midIterator = linkedList.listIterator(midIndex);
        long linkedInsertStart = System.nanoTime();
        midIterator.add(-1); // links new node between neighbors, no shifting
        long linkedInsertTime = System.nanoTime() - linkedInsertStart;

        long linkedRemoveStart = System.nanoTime();
        midIterator.previous(); // move cursor back onto the node just inserted
        midIterator.remove(); // unlinks it directly, no shifting
        long linkedRemoveTime = System.nanoTime() - linkedRemoveStart;

        System.out.println("\n--- Middle insert/delete benchmark (" + elementCount + " elements) ---");
        System.out.println("ArrayList  insert at middle: " + arrayInsertTime + " ns (shifts ~" + (elementCount - midIndex) + " elements)");
        System.out.println("LinkedList insert at middle: " + linkedInsertTime + " ns (relinks 2 pointers)");
        System.out.println("ArrayList  remove at middle: " + arrayRemoveTime + " ns (shifts ~" + (elementCount - midIndex) + " elements)");
        System.out.println("LinkedList remove at middle: " + linkedRemoveTime + " ns (relinks 2 pointers)");
    }

    public static void main(String[] args) {
        internalProcessOfLinkedList demo = new internalProcessOfLinkedList();
        demo.demonstrateDoublyLinkedList();
        demo.explainConstantTimeRemoval();
        demo.benchmarkMiddleInsertAndDelete(100_000);
    }
}
