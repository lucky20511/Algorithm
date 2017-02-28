import java.util.*;

public class Solution {

	public static void main(String[] args){
		
		Solution sol = new Solution();
		System.out.println(sol.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 4));
		
	}
	
	
	
	class Pair{
        
        int idx1;
        int idx2;
        int[] nums;
        Pair(int x, int y, int[] z){
            idx1 = x;
            idx2 = y;
            nums = z;
        }
    }
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<int[]> list = new ArrayList<int[]>();
        if(nums1.length == 0 || nums2.length == 0){
            return list;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return (a.nums[0] + a.nums[1] - b.nums[0] - b.nums[1]);    
            }
        });
        
        for(int i = 0; i < nums1.length; i++){
            pq.offer(new Pair(i, 0, new int[]{nums1[i], nums2[0]}));
        }
        
        for(int i = 0; i < k && !pq.isEmpty(); i++){
            Pair cur = pq.poll();
            list.add(new int[]{cur.nums[0], cur.nums[1]});
            if(cur.idx2 < nums2.length-1)            
            pq.offer(new Pair(cur.idx1, cur.idx2+1, new int[]{nums1[cur.idx1], nums2[cur.idx2+1]}));
        }
        
        return list;
    }
	
}
