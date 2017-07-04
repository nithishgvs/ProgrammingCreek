package org.nithish.trees;

public class LongestConsecutiveSequence {
	// Dont Ctrl+shift+F pic changes
	/**
	 * For example,

   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
	 * @param head
	 * @param prevVal
	 * @param length
	 * @return
	 */

	public static int LongestConsecutiveSequenceBST(Node<Integer> head, Integer prevVal, Integer length) {
		if (head == null) {
			return length;
		}
		int currLen = (prevVal + 1 == head.getData()) ? length + 1 : 1;
		return Math.max(LongestConsecutiveSequenceBST(head.getLeftChild(), head.getData(), currLen),
				LongestConsecutiveSequenceBST(head.getRightChild(), head.getData(), currLen));

	}

	public static void main(String[] args) {
		@SuppressWarnings("unchecked")
		Node<Integer> head = BinarySearchTreeOperations.Insert(null, new Node<Integer>(1));
		head.setRightChild(new Node<Integer>(3));
		head.getRightChild().setLeftChild(new Node<Integer>(2));
		head.getRightChild().setRightChild(new Node<Integer>(4));
		head.getRightChild().getRightChild().setRightChild(new Node<Integer>(5));
		BinarySearchTreeOperations.InorderTraversal(head);
		System.out.println();
		System.out.println(LongestConsecutiveSequenceBST(head,0,0));
	}

}
