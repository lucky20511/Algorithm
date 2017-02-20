import java.util.*;
public class Solution {

	public static void main(String[] args){
		Solution sol = new Solution();
		System.out.println(20+" "+sol.countStairs(200));
		
		
		
	}
	
	
	
	/*
	 * 
	 * dp[i,j] =dp[i-j,j] + dp[i-j,j+1] 
	 * 
	 */
	
//	public int countStairs(int num){
//
//		int[][] dp = new int[num+1][num+1];
//		for(int i = 2; i <= num; i++){
//			dp[i][i] = 1;
//			for(int j = 1; j < i; j++){
//				if(i == num && j == 2){
//					break;
//				}
//				dp[i][j] = dp[i-j][j] + dp[i-j][j+1];
//			}
//		}
//		return dp[num][1];
//	}
	
	
	
//	public int countStairs(int num){
//		int[][] dp = new int[num+1][num+2];
//		for(int i = 2; i <= num; i++) dp[i][i] = 1;
//		for(int i = 2; i <= num; i++) 
//			for(int j = 1; j < i; j++) dp[i][j] = dp[i-j][j] + dp[i-j][j+1];
//		return dp[num][1];
//	}
	
	
	
	public int countStairs(int num){
		int[] dp = new int[num+1];
		dp[0] = 1;
		for(int i = 1; i <= num; i++)
			for(int j = num; j >= i; j--)
				dp[j] += dp[j-i];
		return dp[num]-1;

	}
}
