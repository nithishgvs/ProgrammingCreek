package org.nithish.trees;

public class ValidateBinarySearchTree {

	/**
	 * Check if a tree is BST
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isBST(Node<Integer> root) {
		if (root == null) {
			return true;
		}
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isValidBST(Node<Integer> root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		if (!(root.getData() > minValue && root.getData() <= maxValue)) {
			return false;
		}
		return isValidBST(root.getLeftChild(), minValue, root.getData())
				&& isValidBST(root.getRightChild(), root.getData(), maxValue);
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
		System.out.println(isBST(head));

		Node<Integer> head2 = BinarySearchTreeOperations.Insert(null, new Node<Integer>(1));
		head2.setRightChild(new Node<Integer>(3));
		head2.getRightChild().setLeftChild(new Node<Integer>(8));
		head2.getRightChild().setRightChild(new Node<Integer>(4));
		head2.getRightChild().getRightChild().setRightChild(new Node<Integer>(5));
		System.out.println(isBST(head2));

	}

}
