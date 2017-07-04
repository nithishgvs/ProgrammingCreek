package org.nithish.trees;

import java.util.ArrayList;

public class PathSumBST {

	// Given a binary tree and a sum, determine if the tree has a root-to-leaf
	// path such that adding up all the values along the path equals the given
	// sum.
	/*
	 *        5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
	 * 
	 */
	public static boolean PathSumPresentBST(Node<Integer> root, int Sum) {

		if (root == null) {
			return false;
		}
		if (root.getLeftChild() == null && root.getRightChild() == null && (root.getData() - Sum == 0)) {
			return true;
		}

		return PathSumPresentBST(root.getRightChild(), Sum - root.getData())
				|| PathSumPresentBST(root.getLeftChild(), Sum - root.getData());

	}

	public static boolean PathSumPresentBST(Node<Integer> root, int Sum, ArrayList<Integer> al) {

		if (root == null) {
			return false;
		}
		if (root.getLeftChild() == null && root.getRightChild() == null && (root.getData() - Sum == 0)) {
			al.add(root.getData());
			PrintArrayList(al);
			return true;
		}
		al.add(root.getData());
		return PathSumPresentBST(root.getRightChild(), Sum - root.getData(), new ArrayList<>(al))
				|| PathSumPresentBST(root.getLeftChild(), Sum - root.getData(), new ArrayList<>(al));

	}

	private static void PrintArrayList(ArrayList<Integer> al) {
		for(Integer elem:al){
			System.out.print(elem+"->");
		}
		
	}

	public static void main(String[] args) {
		Node<Integer> head = BinarySearchTreeOperations.Insert(null, new Node<Integer>(5));
		head.setLeftChild(new Node<>(4));
		head.getLeftChild().setLeftChild(new Node<>(11));
		head.getLeftChild().getLeftChild().setLeftChild(new Node<>(7));
		head.getLeftChild().getLeftChild().setRightChild(new Node<>(2));
		head.setRightChild(new Node<>(8));
		head.getRightChild().setLeftChild(new Node<>(13));
		head.getRightChild().setRightChild(new Node<>(4));
		head.getRightChild().getRightChild().setRightChild(new Node<>(1));
		BinarySearchTreeOperations.InorderTraversal(head);
		System.out.println(PathSumPresentBST(head, 26));
		PathSumPresentBST(head,26,new ArrayList<>());
	}

}
