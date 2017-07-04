package org.nithish.trees;

public class ReconstructBSTFromTraversals {

	public static Node ReconInorderandPreorder(int[] In, int[] Pre, int inStart, int inEnd, int preStart, int preEnd) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		int rootData = Pre[preStart];
		int k = 0;
		for (int i = 0; i < In.length; i++) {
			if (In[i] == rootData) {
				k = i;
				break;
			}
		}
		Node<Integer> root = new Node<>(rootData);
		root.setLeftChild(ReconInorderandPreorder(In, Pre, inStart, k - 1, preStart + 1, preStart + (k - inStart)));
		root.setRightChild(ReconInorderandPreorder(In, Pre, k + 1, inEnd, preStart + (k - inStart) + 1, preEnd));
		return root;
	}

	public static void main(String[] args) {
		int[] Inorder = { 15, 30, 35, 40, 45, 50, 60, 70, 72, 75, 77, 80 };
		int[] PreOrder = { 50, 30, 15, 40, 35, 45, 70, 60, 80, 75, 72, 77 };
		int[] In = { 7, 8, 9, 10, 11, 13, 14 };
		int[] Pre = { 10, 8, 7, 9, 13, 11, 14 };
		Node<Integer> root = ReconInorderandPreorder(In, Pre, 0, In.length - 1, 0, Pre.length - 1);
		BinarySearchTreeOperations.InorderTraversal(root);

	}

}
