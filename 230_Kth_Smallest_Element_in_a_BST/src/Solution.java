import java.util.*;


public class Solution {

	/*
	 * 
	 * Directly choose the path we want by count the number of left substree in advance
	 * 
	 */
		
	public int kthSmallest(TreeNode root, int k) {
		// Assume k is valid. 1<= k <=|V| 
		int left_num = CountNode(root.left);
		if(k == left_num + 1){
			return root.val;
		}else if(k <= left_num){
			return kthSmallest(root.left, k);
		}else{
			return kthSmallest(root.right, k-left_num-1);
		}
	}


	private int CountNode(TreeNode node){

		if(node == null){
			return 0;
		}
		return 1+CountNode(node.left)+CountNode(node.right);
	}
	
	
	/*
	 * 
	 * In-order traversal Recursion
	 * 
	 */
	
	public static int current = 1;
	public static int kth = 0;
	
	public int kthSmallest(TreeNode root, int k) {
		current = k-1;
		Recursion(root);
		return kth;
	}
	
	private void Recursion(TreeNode node){
		if(node == null){
			return;
		}
		
		Recursion(node.left);
		if(current == 0){
			kth = node.val;
		}
		current--;
		Recursion(node.right);
	}
	
	
	/*
	 * 
	 * In-order traversal iteration
	 * 
	 */
	
	public int kthSmallest(TreeNode root, int k) {
		int count = 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while(cur != null){
			stack.push(cur);
			cur = cur.left;
		}
		while(!stack.isEmpty()){
			cur = stack.pop();
			count++;
			if(count == k)
				return cur.val;
			cur = cur.right;
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
		}
		return 0;
	}
	
	
	
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
}
