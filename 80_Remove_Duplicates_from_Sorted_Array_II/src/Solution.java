public class Solution {
	public static void main(String[] args){
		
	}
	
	public int removeDuplicates(int[] nums) {
        int count = 1;
        int repeat = 2;
        int p1 = 0;
        for(int p2 = 1; p2 < nums.length; p2++){
            if(nums[p1] != nums[p2] || count < repeat){
                if(nums[p1] == nums[p2]){
                    count++;
                }else{
                    count = 1;
                }
                nums[++p1] = nums[p2];
            }
        }
        return p1+1;
    }
	
}