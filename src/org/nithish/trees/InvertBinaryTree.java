package org.nithish.trees;

public class InvertBinaryTree {

	@SuppressWarnings("rawtypes")
	private Node root;
	
    /**
     * 
     * @param root
     */
	public static void InvertingBinaryTree(Node<Integer> root) {
		if (root == null) {
			return;
		}
		InvertingBinaryTree(root.getLeftChild());
		InvertingBinaryTree(root.getRightChild());
		Node<Integer> temp=root.getLeftChild();
		root.setLeftChild(root.getRightChild());
		root.setRightChild(temp);
		
	}

	public static void main(String[] args) {
		Node<Integer> head =BinarySearchTreeOperations.Insert(null, new Node<Integer>(52));
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
		InvertingBinaryTree(head);
		BinarySearchTreeOperations.InorderTraversal(head);
	}

}
