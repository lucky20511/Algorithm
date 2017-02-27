import java.util.*;

public class Solution {

	
	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list= new ArrayList<List<Integer>>();
        DeleteNode(list, root);
        return list;
    }
    
    private int DeleteNode(List<List<Integer>> list, TreeNode node){
        if(node == null){
            return 0;
        }   
        
        int layer = Math.max(DeleteNode(list, node.left), DeleteNode(list, node.right))+1;
        node.left = null;
        node.right = null;
        if(list.size() < layer){
            list.add(new ArrayList<Integer>());
        }
        list.get(layer-1).add(node.val);
        return layer;
    }
	
	
}
