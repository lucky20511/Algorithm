import java.util.*;

public class Solution {

	public static void main(String[] args){
		Solution sol = new Solution();
		System.out.println(sol.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
		
	}
	
	
	public int findTargetSumWays(int[] nums, int S) {
		int sum = 0;
		for(int n : nums){
			sum += n;
		}
		if(S > sum || S < -1*sum){
			return 0;
		}
		int Target = S+sum;
		int[] dp = new int[2*sum+1];
		dp[sum] = 1;
		for(int n : nums){
			int[] tmp = new int[2*sum+1];
			for(int j = n; j < dp.length-n; j++){
			//for(int j = 0; j < dp.length; j++){
				if(dp[j] > 0){
					tmp[j+n] += dp[j];
					tmp[j-n] += dp[j];
				}
			}
			dp = tmp;
		}
		return dp[Target];
		
	}
	
}
