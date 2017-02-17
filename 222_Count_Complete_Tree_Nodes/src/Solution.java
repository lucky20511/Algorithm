
public class Solution {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
	/*
	 * 
	 * Recursion
	 * 
	 */
	public int countNodes(TreeNode root) {
        //traverse left side and right side.  check if these two sides are the same
        if(root == null){
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int count = 0;
        while(left != null && right != null){
            left = left.left;
            right = right.right;
            count++;
        }
        // if the same, return
        if(left == right){
            return (1<<(count+1))-1;
        // else return split
        }else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
	
	/* 
	 * 
	 * Iteration
	 * 
	 */
	public int countNodes(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		int total = 0;
		while(!stack.isEmpty()){
			TreeNode cur = stack.pop();
			if(cur == null){
				continue;
			}
			TreeNode l = cur.left;
			TreeNode r = cur.right;
			int count = 0;
			while(l != null && r != null){
				count++;
				l = l.left;
				r = r.right;
			}
			if(l == r){
				total += (1<<(count+1))-1;
			}else{
				total++;
				stack.push(cur.left);
				stack.push(cur.right);
			}
		}

		return total;
	}
	
	
}
