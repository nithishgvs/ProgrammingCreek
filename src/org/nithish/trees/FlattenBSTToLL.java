package org.nithish.trees;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class FlattenBSTToLL {

	public static void FlattenBSTtoLinkedList(Node<Integer> root) {

		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		LinkedList<Integer> ll = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<Integer> elem = queue.peek();
			ll.add(elem.getData());
			queue.remove();
			if (elem.getLeftChild() != null) {
				queue.add(elem.getLeftChild());
			}
			if (elem.getRightChild() != null) {
				queue.add(elem.getRightChild());
			}
		}
		ListIterator<Integer> itr = ll.listIterator();
		while (itr.hasNext()) {
			System.out.print(itr.next()+"->");
		}

	}

	public static void main(String[] args) {
		Node<Integer> head = BinarySearchTreeOperations.Insert(null, new Node<Integer>(52));
		BinarySearchTreeOperations.Insert(head, new Node<Integer>(33));
		BinarySearchTreeOperations.Insert(head, new Node<Integer>(25));
		BinarySearchTreeOperations.Insert(head, new Node<Integer>(12));
		BinarySearchTreeOperations.Insert(head, new Node<Integer>(27));
		BinarySearchTreeOperations.Insert(head, new Node<Integer>(39));
		BinarySearchTreeOperations.Insert(head, new Node<Integer>(34));
		BinarySearchTreeOperations.Insert(head, new Node<Integer>(48));
		BinarySearchTreeOperations.Insert(head, new Node<Integer>(65));
		BinarySearchTreeOperations.Insert(head, new Node<Integer>(60));
		BinarySearchTreeOperations.Insert(head, new Node<Integer>(78));
		BinarySearchTreeOperations.Insert(head, new Node<Integer>(72));
		BinarySearchTreeOperations.Insert(head, new Node<Integer>(90));
		BinarySearchTreeOperations.InorderTraversal(head);
		System.out.println();
		FlattenBSTtoLinkedList(head);
	}

}
