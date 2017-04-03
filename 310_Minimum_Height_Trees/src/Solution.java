import java.util.*;

public class Solution {

	public static void main(String[] args){
		
		
	}
	
	public List<Integer> findMinHeightTrees(int n, int[][] edges){
		// Create the list of set to recording the all child nodes 
		List<Set<Integer>> list = new ArrayList<Set<Integer>>();
		for(int i = 0; i < n; i++){
		    list.add(new HashSet<Integer>());
		}
		for(int[] e : edges){
		    list.get(e[0]).add(e[1]);
		    list.get(e[1]).add(e[0]);
		}
		
		// Topological sorting, starting from leaf nodes, and terminates at only two or one left nodes
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < n; i++){
		    if(list.get(i).size() == 1){
		        queue.offer(i);
		    }
		}
		int left_node = n;
		while(left_node > 2){
		    int queueSize = queue.size();
		    left_node -= queueSize;
		    for(int j = 0; j < queueSize; j++){
		        int curNode = queue.poll();
		        for(int next : list.get(curNode)){
		            list.get(next).remove(curNode);
		            if(list.get(next).size() == 1){
		                queue.offer(next);
		            }
		        }
		    }
		}
		List<Integer> retList = new ArrayList<Integer>();
		while(!queue.isEmpty()){
		    retList.add(queue.poll());
		}
		if(retList.isEmpty()){
		    retList.add(0);
		}
		return retList;
		
		
	}
		
}
