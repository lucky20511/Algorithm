import java.util.*;

public class Solution {
	
	public static void main(String[] args){
		Solution sol = new Solution();
		System.out.println(sol.TwoBomb(6, 7));
	}
	
	public int TwoBomb(int i, int j){
		
		int count = 0;
		for(; i != 1 || j != 1;count++)
			if(j > i) j -= i;
			else i -= j;
		return count;
	}
	
	
	
	
	
	
	
	
	
	
//	public int TwoBomb(int i, int j){
//		
//		int count = 0;
//		while(i != 1 || j != 1){
//			if(j > i){
//				j -= i;
//			}else{ // j <= i
//				i -= j;
//			}
//			count++;
//			
//		}
//		return count;
//	}
}
