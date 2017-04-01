import java.util.*;

public class Solution {
	
	public static void main(){
		
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/*
	 * Method I:
	 * 	First Check: the difference of height of left and right child node is within 1
	 * 	Second Check: subtree is also balanced
	 */

	public boolean isBalanced(TreeNode root) {
		if(root == null){
			return true;
		}
		if(Math.abs(Height(root.left) - Height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
		//if(isBalanced(root.left) && isBalanced(root.right) && Math.abs(Height(root.left) - Height(root.right)) <= 1){
			return true;
		}else{
			return false;
		}    
	}

	private int Height(TreeNode root){
		if(root == null){
			return 0;
		}
		return Math.max(Height(root.left), Height(root.right))+1;
	}

	    
	/*
	 * Method II:
	 * 	First Check: subtree is also balanced
	 * 	Second Check: the difference of height of left and right child node is within 1
	 */
//	public boolean isBalanced(TreeNode root) {
//		if(root == null){
//			return true;
//		}
//		//if(Math.abs(Height(root.left) - Height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
//		if(isBalanced(root.left) && isBalanced(root.right) && Math.abs(Height(root.left) - Height(root.right)) <= 1){
//			return true;
//		}else{
//			return false;
//		}    
//	}
//
//	private int Height(TreeNode root){
//		if(root == null){
//			return 0;
//		}
//		return Math.max(Height(root.left), Height(root.right))+1;
//	}
	
	/*
	 * Method III:
	 * 	First Check: the difference of height of left and right child node is within 1
	 * 	Second Check: subtree is also balanced
	 *  Using Memoization
	 */
//	public Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
//
//	public boolean isBalanced(TreeNode root) {
//		if(root == null){
//			return true;
//		}
//		if(Math.abs(Height(root.left) - Height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
//			//if(isBalanced(root.left) && isBalanced(root.right) && Math.abs(Height(root.left) - Height(root.right)) <= 1){
//			return true;
//		}else{
//			return false;
//		}    
//	}
//
//	private int Height(TreeNode root){
//		if(root == null){
//			return 0;
//		}
//		if(!map.containsKey(root)){
//			map.put(root, Math.max(Height(root.left), Height(root.right))+1);
//		}
//		return map.get(root);
//	}
	
	
	/*
	 * Method IV:
	 * 	First Check: subtree is also balanced
	 * 	Second Check: the difference of height of left and right child node is within 1
	 *  Using Memoization
	 */
//	public Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
//
//	public boolean isBalanced(TreeNode root) {
//		if(root == null){
//			return true;
//		}
//		//if(Math.abs(Height(root.left) - Height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
//		if(isBalanced(root.left) && isBalanced(root.right) && Math.abs(Height(root.left) - Height(root.right)) <= 1){
//			return true;
//		}else{
//			return false;
//		}    
//	}
//
//	private int Height(TreeNode root){
//		if(root == null){
//			return 0;
//		}
//		if(!map.containsKey(root)){
//			map.put(root, Math.max(Height(root.left), Height(root.right))+1);
//		}
//		return map.get(root);
//	}
	
}
