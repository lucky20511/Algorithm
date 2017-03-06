
public class Solution {

	
	/*
	 * Method I: recursion + HashMap
	 * Method II: Iteration + HashMap (Not yet implemented)
	 */
	
	
	/*
	 *  Method I: recursion + HashMap
	 */
	
	public RandomListNode copyRandomList(RandomListNode head) {
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		map.put(null, null);
		return helper(map, head);
	}

	private RandomListNode helper(Map<RandomListNode, RandomListNode> map, RandomListNode node){
		if(map.containsKey(node)){
			return map.get(node);
		}
		RandomListNode new_node = new RandomListNode(node.label);
		map.put(node, new_node);
		new_node.next = helper(map, node.next);
		new_node.random = helper(map, node.random);
		//map.put(node, new_node);
		return new_node;

		
	}
	
	
	/*
	 *  Method II: Iteration + HashMap
	 */

}
