package org.nithish.trees;

import java.util.LinkedList;
import java.util.Queue;

public class KthSmallestBST {

	@SuppressWarnings("rawtypes")
	private Node root;

	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void InorderTraversal(Node<Integer> root) {
		if (root == null)
			return;
		if (root.getLeftChild() != null) {
			InorderTraversal(root.getLeftChild());
		}
		// System.out.print(root.getData() + "->");
		queue.add(root.getData());
		if (root.getRightChild() != null) {
			InorderTraversal(root.getRightChild());
		}
	}

	public static void KthLargest(Node<Integer> head, int K) {
		InorderTraversal(head);
		for (int i = 1; i <= K; i++) {
			if (i == K) {
				System.out.println(queue.poll());
				break;
			}
			queue.remove();
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
		KthLargest(head, 3);
	}

}
