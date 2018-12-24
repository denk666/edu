package com.dkorolev.edu.linkedlists;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
	List<TestInner> testsList = Arrays.asList(new TestAdd(), new TestRemoveInMiddle(), new TestRemoveEdges(),
		new TestDoubleRemoveEdges(), new TestAddRemoveAdd());

	for (TestInner test : testsList) {
	    boolean result = test.doTest();
	    System.out.println(new StringBuilder("Test ").append(test.getClass().getSimpleName()).append(": ")
		    .append(result ? "OK" : "FAIL"));
	}
    }

    private static interface TestInner {
	abstract boolean doTest();
    }

    private static class TestAdd implements TestInner {
	@Override
	public boolean doTest() {
	    LinkedList list = new LinkedList();

	    for (int i = 0; i < 10; i++) {
		if (list.find(i) != null) {
		    return false;
		}
	    }
	    for (int i = 0; i < 10; i++) {
		list.addInTail(new Node(i));
	    }
	    for (int i = 0; i < 10; i++) {
		if (list.find(i) == null) {
		    return false;
		}
	    }
	    return true;
	}
    }

    private static class TestRemoveInMiddle implements TestInner {
	@Override
	public boolean doTest() {
	    LinkedList list = new LinkedList();
	    for (int i = 0; i < 10; i++) {
		list.addInTail(new Node(i));
	    }
	    int checkInt = 5;
	    if (list.find(checkInt) == null) {
		return false;
	    }
	    list.remove(checkInt);
	    if (list.find(checkInt) != null) {
		return false;
	    }
	    for (int i : new Integer[] { 0, 1, 2, 3, 4, 6, 7, 8, 9 }) {
		if (list.find(i) == null) {
		    return false;
		}
	    }
	    return true;
	}
    }

    private static class TestRemoveEdges implements TestInner {
	@Override
	public boolean doTest() {
	    LinkedList list = new LinkedList();
	    for (int i = 0; i < 10; i++) {
		list.addInTail(new Node(i));
	    }
	    int start = 0;
	    int end = 9;
	    if (list.find(start) == null || list.find(end) == null) {
		return false;
	    }
	    list.remove(start);
	    list.remove(end);
	    if (list.find(start) != null || list.find(end) != null) {
		return false;
	    }
	    for (int i : new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }) {
		if (list.find(i) == null) {
		    return false;
		}
	    }
	    return true;
	}
    }

    private static class TestDoubleRemoveEdges implements TestInner {
	@Override
	public boolean doTest() {
	    LinkedList list = new LinkedList();
	    for (int i = 0; i < 10; i++) {
		list.addInTail(new Node(i));
	    }
	    for (int i = 0; i < 10; i++) {
		if (list.find(i) == null) {
		    return false;
		}
	    }
	    list.remove(0);
	    list.remove(9);
	    list.remove(1);
	    list.remove(8);
	    if (list.find(0) != null || list.find(1) != null || list.find(8) != null || list.find(9) != null) {
		return false;
	    }
	    for (int i : new Integer[] { 2, 3, 4, 5, 6, 7 }) {
		if (list.find(i) == null) {
		    return false;
		}
	    }
	    return true;
	}
    }

    private static class TestAddRemoveAdd implements TestInner {
	@Override
	public boolean doTest() {
	    LinkedList list = new LinkedList();
	    for (int i = 0; i < 10; i++) {
		list.addInTail(new Node(i));
	    }
	    for (int i = 0; i < 10; i++) {
		if (list.find(i) == null) {
		    return false;
		}
	    }
	    list.remove(0);
	    list.remove(9);
	    list.remove(1);
	    list.remove(8);
	    if (list.find(0) != null || list.find(1) != null || list.find(8) != null || list.find(9) != null) {
		return false;
	    }
	    for (int i : new Integer[] { 2, 3, 4, 5, 6, 7 }) {
		if (list.find(i) == null) {
		    return false;
		}
	    }
	    for (int i = 0; i < 10; i++) {
		list.addInTail(new Node(i));
	    }
	    for (int i : new Integer[] { 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }) {
		if (list.find(i) == null) {
		    return false;
		}
	    }
	    list.remove(2);
	    for (int i : new Integer[] { 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }) {
		if (list.find(i) == null) {
		    return false;
		}
	    }
	    return true;
	}
    }
}
