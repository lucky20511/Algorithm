import java.util.*;


public class Solution {
	
	public static void main(String[] args){
		Solution sol = new Solution();
		System.out.println(sol.combinationSum2(new int[]{1,1,2,2,3,3,3}, 5));
	}
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> ls = new ArrayList<Integer>();
        if(candidates.length == 0){
            return list;
        }
        helper(list, ls, candidates, target, 0);
        return list;
    }

    
    private void helper(List<List<Integer>> list, List<Integer> ls, int[] nums, int target, int pos){
              
        if(target == 0){
            list.add(new ArrayList<Integer>(ls));
            return;
        }
        if(pos >= nums.length || nums[pos] > target){
            return;
        }  
        
        for(int i = pos; i < nums.length; i++){
            if(i == pos || nums[i] != nums[i-1]){    // too beautiful
                ls.add(nums[i]);
                helper(list, ls, nums, target-nums[i], i+1);
                ls.remove(ls.size()-1);
            }
        }
        
    }
}
