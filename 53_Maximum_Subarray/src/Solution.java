import java.util.*;

public class Solution {

	public static void main(String[] args){
		
		Solution sol = new Solution();
		System.out.println(sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
		
	}
	
	
	public int maxSubArray(int[] nums) {
    
		int Max = Integer.MIN_VALUE;
		int total = 0;
		for(int n : nums){
			total += n;
			if(Max < total ){
				Max = total;
			}
			// need to prove when total < 0, there is no substrings in the left part > 0!
			if(total < 0){
				total = 0;
			}
		}
		return Max;
    }
	
	
}
