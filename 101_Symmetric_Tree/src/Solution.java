public class Solution {
	
	
	/*
	 * Recursion -- bottom up
	 * 
	 */
	
	public class TreeNode {
		int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}

	public boolean isSymmetric(TreeNode root) {
		if(root == null){
			return true;
		}
		return Check(root.left, root.right);
    }
	
	private boolean Check(TreeNode left, TreeNode right){
		if(left == null || right == null){
		    if(left == null && right == null){
		        return true;
		    }    
		    else{
		        return false;
		    }
		}
		    
		if(left.val != right.val){
			return false;
		}else{
		    return Check(left.left, right.right) && Check(left.right, right.left);
		}
	}
	
	/*
	 * 
	 * Iteration - top down
	 * 
	 */
	
	class NodePair{
		NodePair(TreeNode l, TreeNode r){
			this.left = l;
			this.right = r;
		}
		TreeNode left;
		TreeNode right;
	}


	public boolean isSymmetric(TreeNode root) {
		if(root == null){
			return true;
		}
		Stack<NodePair> stack = new Stack<NodePair>();
		stack.push(new NodePair(root.left, root.right));
		while(!stack.isEmpty()){
			NodePair np = stack.pop();
			TreeNode l = np.left;
			TreeNode r = np.right;
			if(l == null || r == null){
				if( l != r){
					return false;
				}
			}else{
				if(l.val != r.val){
					return false;
				}
				stack.push(new NodePair(l.left, r.right));
				stack.push(new NodePair(l.right, r.left));
			}
		}
		return true;

	}
}
