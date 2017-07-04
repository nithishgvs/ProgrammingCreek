package org.nithish.trees;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class BinarySearchTreeOperations {

	@SuppressWarnings("rawtypes")
	private Node root;

	@SuppressWarnings("rawtypes")
	public static Node Insert(Node<Integer> root, Node<Integer> node) {
		if (root == null) {
			return node;
		}
		if (node.getData() < root.getData()) {
			root.setLeftChild(Insert(root.getLeftChild(), node));
		} else if (node.getData() >= root.getData()) {
			root.setRightChild(Insert(root.getRightChild(), node));
		}
		return root;
	}

	public static void InorderTraversal(Node<Integer> root) {
		if (root == null)
			return;
		if (root.getLeftChild() != null) {
			InorderTraversal(root.getLeftChild());
		}
		System.out.print(root.getData() + "->");
		if (root.getRightChild() != null) {
			InorderTraversal(root.getRightChild());
		}

	}

	public static void PostorderTraversal(Node<Integer> root) {
		if (root == null)
			return;
		if (root.getLeftChild() != null) {
			PostorderTraversal(root.getLeftChild());
		}
		if (root.getRightChild() != null) {
			PostorderTraversal(root.getRightChild());
		}
		System.out.print(root.getData() + "->");
	}

	public static void PreorderTraversal(Node<Integer> root) {
		if (root == null)
			return;
		System.out.print(root.getData() + "->");
		if (root.getLeftChild() != null) {
			PreorderTraversal(root.getLeftChild());
		}
		if (root.getRightChild() != null) {
			PreorderTraversal(root.getRightChild());
		}
	}

	public static void LevelOrderTraversal(Node<Integer> root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<Integer> elem = queue.peek();
			if (elem.getLeftChild() != null) {
				queue.add(elem.getLeftChild());
			}
			if (elem.getRightChild() != null) {
				queue.add(elem.getRightChild());
			}
			queue.remove();
			System.out.print(elem.getData()+"->");

		}
	}

	public static void main(String[] args) {
		Node<Integer> head = Insert(null, new Node<Integer>(52));
		Insert(head, new Node<Integer>(33));
		Insert(head, new Node<Integer>(25));
		Insert(head, new Node<Integer>(12));
		Insert(head, new Node<Integer>(27));
		Insert(head, new Node<Integer>(39));
		Insert(head, new Node<Integer>(34));
		Insert(head, new Node<Integer>(48));
		Insert(head, new Node<Integer>(65));
		Insert(head, new Node<Integer>(60));
		Insert(head, new Node<Integer>(78));
		Insert(head, new Node<Integer>(72));
		Insert(head, new Node<Integer>(90));
		InorderTraversal(head);

	}

}
