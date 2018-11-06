package com.dkorolev.edu.linkedlists;

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
	this.head = null;
	this.tail = null;
    }

    public void addInTail(Node item) {
	if (head == null) {
	    head = item;
	} else {
	    tail.next = item;
	}
	tail = item;
    }

    public Node find(int val) {
	Node node = head;
	while (node != null) {
	    if (node.value == val) {
		return node;
	    }
	    node = node.next;
	}
	return null;
    }

    public void remove(int val) {
	remove(val, false);
    }

    public void remove(int val, boolean removeAll) {
	Node prevNode = null;
	Node node = head;
	while (node != null) {
	    if (node.value == val) {
		if (prevNode != null) {
		    prevNode.next = node.next;
		}
		if (head == node) {
		    head = node.next;
		}
		if (tail == node) {
		    tail = prevNode;
		}
		if (!removeAll) {
		    return;
		}
	    } else {
		prevNode = node;
	    }
	    node = node.next;
	}
    }

    @Override
    public String toString() {
	StringBuilder s = new StringBuilder("[");
	Node node = head;
	while (node != null) {
	    s.append(node.value).append(node.next == null ? "" : ";");
	    node = node.next;
	}
	s.append("]");
	return s.toString();
    }
}
