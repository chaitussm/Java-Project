package com.collections;

import java.util.*;
public class cursors {

	public void demonstrateIterator() {
		List<String> names = new ArrayList<>(List.of("Asha", "Bala", "Chitra", "Dinesh"));
        System.out.println("iterator implemented class object is :" + names.getClass().getName());
		Iterator<String> iterator = names.iterator();

		System.out.print("Iterator forward: ");
		while (iterator.hasNext()) {
			String name = iterator.next();
			if (name.startsWith("B")) {
				iterator.remove();
			} else {
				System.out.print(name + " ");
			}
		}
		System.out.println();
		System.out.println("After Iterator.remove(): " + names);
	}

	public void demonstrateListIterator() {
		List<String> names = new ArrayList<>(List.of("Asha", "Bala", "Chitra"));
        System.out.println("listIterator implemented class object is :" + names.getClass().getName());
		ListIterator<String> iterator = names.listIterator();

		while (iterator.hasNext()) {
			String name = iterator.next();
			if (name.equals("Bala")) {
				iterator.set("Bharat");
				iterator.add("Bhavna");
			}
		}

		System.out.println("ListIterator after set() and add(): " + names);
		System.out.print("ListIterator backward: ");
		while (iterator.hasPrevious()) {
			System.out.print(iterator.previous() + " ");
		}
		System.out.println();
	}

	public void demonstrateEnumeration() {
		Vector<String> values = new Vector<>(List.of("one", "two", "three"));
        System.out.println("enumeration implemented class object is :" + values.getClass().getName());
		Enumeration<String> enumeration = values.elements();

		System.out.print("Enumeration forward: ");
		while (enumeration.hasMoreElements()) {
			System.out.print(enumeration.nextElement() + " ");
		}
		System.out.println();
	}

	public void demonstrateSpliterator() {
		List<String> values = List.of("one", "two", "three", "four");
        System.out.println("spliterator implemented class object is :" + values.getClass().getName());
		Spliterator<String> firstHalf = values.spliterator();
		Spliterator<String> secondHalf = firstHalf.trySplit();

		System.out.print("Spliterator first part: ");
		if (secondHalf != null) {
			secondHalf.forEachRemaining(value -> System.out.print(value + " "));
			/*
			secondHalf.forEachRemaining(new java.util.function.Consumer<String>() {
				@Override
				public void accept(String value) {
					System.out.print(value + " ");
				}
			});
			*/
		}
		System.out.print("\nSpliterator second part: ");
		firstHalf.forEachRemaining(value -> System.out.print(value + " "));
		/*
		firstHalf.forEachRemaining(new java.util.function.Consumer<String>() {
			@Override
			public void accept(String value) {
				System.out.print(value + " ");
			}
		});
		*/
		System.out.println();
	}

	public static void main(String[] args) {
		cursors demo = new cursors();
		demo.demonstrateIterator();
		demo.demonstrateListIterator();
		demo.demonstrateEnumeration();
		demo.demonstrateSpliterator();
	}
}
