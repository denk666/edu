package com.dkorolev.edu.linkedlists;

public class Test {
    public static void main(String[] args) {
	LinkedList list = new LinkedList();
	
	for (int i = 0; i < 10; i++) {
	    list.addInTail(new Node(i));
	}
	
	System.out.println(list);
	list.remove(5);
	System.out.println(list);
	list.remove(0);
	System.out.println(list);
	list.remove(9);
	System.out.println(list);
	list.remove(1);
	System.out.println(list);
	list.remove(8);
	System.out.println(list);
	
	for (int i = 0; i < 10; i++) {
	    list.addInTail(new Node(i));
	}
	System.out.println(list);
	
	list.remove(2);
	System.out.println(list);
    }
}
