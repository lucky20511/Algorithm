import java.util.*;

public class Solution {
	
	public static void main(String[] args){
		Solution sol = new Solution();
		System.out.println(sol.containsNearbyDuplicate(new int[]{1, 4, 7, 11, 7 }, 2));

	}
	
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        
		/*
		 * Method I: HashMap
		 */
		// Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for(int i = 0; i < nums.length; i++){
        //     if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k){
        //         return true;
        //     }else{
        //         map.put(nums[i], i);
        //     }
        // }
        // return false;
        
		
		/*
		 * Method II: HashMap
		 */
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])){
                return true;
            }
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;
        
        
        
    }
}
