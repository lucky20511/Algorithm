import java.util.*;

public class Solution {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // Create new list
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        // BFS
        while(!queue.isEmpty()){
            List<Integer> ls = new ArrayList<Integer>();
            int level_size = queue.size();
            for(int i = 0; i < level_size; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    ls.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            // Append
            if(ls.size() > 0){
                list.add(0, ls);
            }
        }
        return list;

    }
	
	
}
