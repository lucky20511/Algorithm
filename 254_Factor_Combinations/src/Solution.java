import java.util.*;
public class Solution {

	public static void main(String[] args){
		Solution sol = new Solution();
		System.out.println(sol.getFactors(128));
	}
	
	
	public List<List<Integer>> getFactors(int n) {
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Helper(list, new ArrayList<Integer>(), n, 2);
		return list;
    }
	
	private void Helper(List<List<Integer>> list, List<Integer> ls, int current, int low){
		if(current == 1){
			return;
		}
		
		for(int i = low; i*i <= current; i++){
			if(current % i == 0){
				ls.add(i);
				int left = current / i;
				ls.add(left);
				list.add(new ArrayList<Integer>(ls));
				ls.remove(ls.size()-1);
				Helper(list, ls, left, i);
				ls.remove(ls.size()-1);
			}
		}
		
	}
	
}
