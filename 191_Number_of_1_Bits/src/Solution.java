import java.util.*;

public class Solution {

	public static void main(String[] args){
		
		Solution sol = new Solution();
		System.out.println(sol.hammingWeight(439202));
		
	}
	
	
	public int hammingWeight(int n) {
		
		/*
		 * Method 1
		 */
		
//		int count = 0;
//		for(int i = 31; i >= 0; i--){
//			if( ((n>>i) & 1) > 0){
//				count++;
//			}
//		}
//		return count;
		
		
		/*
		 * Method 2
		 */
		int count = 0;
		while(n != 0){
			n &= n-1;
			count++;
		}
		return count;
	}
	
	
}
