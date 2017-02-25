import java.util.*;
public class Solution {

	public static void main(String args[])
	{
		int val[] = new int[]{60, 100, 120};
		int wt[] = new int[]{10, 20, 30};
		int W = 50;
		Solution sol = new Solution();
		
		System.out.println(sol.knapsack(wt, val, W));
	}
	
	
	public int knapsack(int[] weights, int[] values, int weight_limit){
		
		int[] dp = new int[weight_limit+1];
		int[] pos = new int[weight_limit+1];
		int ret_max = 0;
		pos[0] = 1;
		for(int i = 0; i < weights.length; i++){
			for(int j = weight_limit; j >= 0; j--){
				if(j-weights[i] >= 0 && pos[j-weights[i]] == 1){
					dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
					if(dp[j] > ret_max){
						ret_max = dp[j];
					}
					pos[j] = 1;
				}
			}
		}
		return ret_max;
	}
	
//	public int knapsack(int[] weights, int[] values, int weight_limit){
//		
//		int[] dp = new int[weight_limit+1];
//		int[] pos = new int[weight_limit+1];
//		int ret_max = 0;
//		pos[0] = 1;
//		for(int i = 0; i < weights.length; i++)
//			for(int j = weight_limit; j >= 0; j--)
//				if(j-weights[i] >= 0 && pos[j-weights[i]] == 1){
//					dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
//					ret_max = Math.max(ret_max, dp[j]);
//					pos[j] = 1;
//				}
//
//		return ret_max;
//	}
	
	
}
