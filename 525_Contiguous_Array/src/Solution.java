import java.util.*;

public class Solution {

	public static void main(String[] args){
		Solution sol = new Solution();
		System.out.println(sol.findMaxLength(new int[]{0,1,1,0,1,1,1,0}));
		
		
	}
	
	
	public int findMaxLength(int[] nums) {
        
        int MaxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,-1);  // very important
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
            sum += nums[i];
            if(map.containsKey(sum)){
            	MaxLen = Math.max(MaxLen, i-map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return MaxLen;
    }
	
	
	
}
