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
		list.addInTail(new Node(i));
	    }
	    return "[0;1;2;3;4;5;6;7;8;9]".equals(list.toString());
	}
    }

    private static class TestRemoveInMiddle implements TestInner {
	@Override
	public boolean doTest() {
	    LinkedList list = new LinkedList();
	    for (int i = 0; i < 10; i++) {
		list.addInTail(new Node(i));
	    }
	    list.remove(5);
	    return "[0;1;2;3;4;6;7;8;9]".equals(list.toString());
	}
    }

    private static class TestRemoveEdges implements TestInner {
	@Override
	public boolean doTest() {
	    LinkedList list = new LinkedList();
	    for (int i = 0; i < 10; i++) {
		list.addInTail(new Node(i));
	    }
	    list.remove(0);
	    list.remove(9);
	    return "[1;2;3;4;5;6;7;8]".equals(list.toString());
	}
    }

    private static class TestDoubleRemoveEdges implements TestInner {
	@Override
	public boolean doTest() {
	    LinkedList list = new LinkedList();
	    for (int i = 0; i < 10; i++) {
		list.addInTail(new Node(i));
	    }
	    list.remove(0);
	    list.remove(9);
	    list.remove(1);
	    list.remove(8);
	    return "[2;3;4;5;6;7]".equals(list.toString());
	}
    }

    private static class TestAddRemoveAdd implements TestInner {
	@Override
	public boolean doTest() {
	    LinkedList list = new LinkedList();
	    for (int i = 0; i < 10; i++) {
		list.addInTail(new Node(i));
	    }
	    list.remove(0);
	    list.remove(9);
	    list.remove(1);
	    list.remove(8);
	    for (int i = 0; i < 10; i++) {
		list.addInTail(new Node(i));
	    }
	    list.remove(2);
	    return "[3;4;5;6;7;0;1;2;3;4;5;6;7;8;9]".equals(list.toString());
	}
    }
}
