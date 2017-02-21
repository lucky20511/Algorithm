import java.util.*;

public class Solution {

		public static void main(String[] args){
			Solution sol = new Solution();
			System.out.println(sol.wordPattern("aaa", "abc abc abc"));
			
			
			
		}
	
	
	public boolean wordPattern(String pattern, String str) {
		String[] check = new String[26];
		String[] str_array = str.split(" ");
		
		HashSet<String> set = new HashSet<String>();
		
		if(str_array.length != pattern.length()){
			return false;
		}
		int count = 0;
		for(char c : pattern.toCharArray()){
			int idx = c-'a';
			if(check[idx] == null){
				if(set.add(str_array[count])){
					check[idx] = str_array[count]; 
				}else{
					return false;
				}
			}else{
				if(!check[idx].equals(str_array[count])){
					return false;
				}
			}
			count++;
		}
		
		return true;
		
    }
	
}
