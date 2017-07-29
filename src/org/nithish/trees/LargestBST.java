package org.nithish.trees;

public class LargestBST {

	private static class MinMaxClass {
		int minVal;
		int maxVal;
		boolean isBst;
		int length;

		public MinMaxClass(int minVal, int maxVal, boolean isBst, int length) {
			this.minVal = minVal;
			this.maxVal = maxVal;
			this.isBst = isBst;
			this.length = length;
		}

		public MinMaxClass() {
			// TODO Auto-generated constructor stub
		}

	}

	@SuppressWarnings("null")
	public static MinMaxClass findLargestBst(Node root) {
		if (root == null) {
			return new MinMaxClass(0, 0, false, 0);
		}
		if (root.getLeftChild() == null && root.getRightChild() == null) {
			return new MinMaxClass((int) root.getData(), (int) root.getData(), true, 1);
		}
		MinMaxClass left = null;
		MinMaxClass right = null;
		MinMaxClass returnVal = new MinMaxClass();
		if (root.getLeftChild() != null) {
			left = findLargestBst(root.getLeftChild());
		}
		if (root.getRightChild() != null) {
			right = findLargestBst(root.getRightChild());
		}
		if (left != null && right != null) {
			returnVal.length = (1 + left.length + right.length);
			if (left.isBst && right.isBst && (int) left.minVal < (int) root.getData()
					&& (int) right.minVal > (int) root.getData()) {
				returnVal.minVal = Math.min(left.minVal, Math.min(right.minVal, (int) root.getData()));
				returnVal.maxVal = Math.max(right.maxVal, Math.max(left.maxVal, (int) root.getData()));
				returnVal.isBst = true;
				return returnVal;
			}
		}

		// If whole tree is not BST, return maximum
		// of left and right subtrees
		returnVal.minVal = 0;
		returnVal.maxVal = 0;
		returnVal.isBst = false;

		return returnVal;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		BinarySearchTreeOperations op = new BinarySearchTreeOperations();
		Node<Integer> head = op.Insert(null, new Node<Integer>(25));
		head.setLeftChild(new Node<Integer>(18));
		head.getLeftChild().setLeftChild(new Node<Integer>(19));
		head.getLeftChild().getLeftChild().setRightChild(new Node<Integer>(15));
		head.getLeftChild().setRightChild(new Node<Integer>(20));
		head.getLeftChild().getRightChild().setLeftChild(new Node<Integer>(18));
		head.getLeftChild().getRightChild().setRightChild(new Node<Integer>(25));
		head.setRightChild(new Node<Integer>(50));
		head.getRightChild().setLeftChild(new Node<Integer>(35));
		head.getRightChild().getLeftChild().setLeftChild(new Node<Integer>(20));
		head.getRightChild().getLeftChild().getLeftChild().setRightChild(new Node<Integer>(25));
		head.getRightChild().getLeftChild().setRightChild(new Node<Integer>(40));
		head.getRightChild().setRightChild(new Node<Integer>(60));
		head.getRightChild().getRightChild().setLeftChild(new Node<Integer>(55));
		head.getRightChild().getRightChild().setRightChild(new Node<Integer>(70));
		op.InorderTraversal(head);
		MinMaxClass cl = findLargestBst(head);
		System.out.println(cl.length);
	}

}
