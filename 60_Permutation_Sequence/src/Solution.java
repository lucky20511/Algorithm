import java.util.*;

public class Solution {
	
	public static void main(String[] args){
		Solution sol = new Solution();
		System.out.println(sol.getPermutation(6, 720));
	}
	
	
	/*
	 * Trick 1:   k--;
	 * Trick 2:   use list.add  list.get  list.remove 
	 *       	  to find the kth element of each layer
	 */
	
	public String getPermutation(int n, int k){
		// assume n > 0 and k > 0
		
		//create factoral array
		int[] factor = new int[n];
		factor[0] = 1;
		for(int i = 1; i < n; i++){
			factor[i] = i*factor[i-1];
		}
		
		StringBuilder sb = new StringBuilder();
		boolean[] check = new boolean[n+1];
		// check n layer
		for(int i = n; i >=1; i--){
			int branch = k/factor[i-1];
			int left = k%factor[i-1];
			// if tree is full
			if(left > 0){
				branch++;
			}
			//update the k
			k -= (branch-1)*factor[i-1];
			
			/* find the (branch)th value of current layer */
			int index = 1;
			for(int j = 0; j < branch; j++, index++){
				while(check[index]){
					index++;
				}
			}
			check[--index] = true;
			sb.append(Integer.toString(index));

		}
		
		return sb.toString();
	}
	
}
