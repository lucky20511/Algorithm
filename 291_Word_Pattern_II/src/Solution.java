import java.util.*;
public class Solution {

	
	public static void main(String[] args){
		Solution sol = new Solution();
		System.out.println(sol.wordPatternMatch("aaaa", "asdasdasdasd"));
		System.out.println(sol.wordPatternMatch("p", ""));
		
	}
	
	
	public boolean wordPatternMatch(String pattern, String str) {
		if(pattern.length() == 0 && str.length() == 0){
			return true;
		}else if(pattern.length() == 0 || pattern.length() > str.length()){
			return false;
		}
		String[] check = new String[26];
		HashSet<String> set = new HashSet<String>();
		return PatternSearch(pattern, str, check, set);
    }
	
	private boolean PatternSearch(String pattern, String str, String[] check, HashSet<String> set){
		char pat = pattern.charAt(0);
		int idx = pat-'a';
		if(pattern.length() == 1){
			if(check[idx] == null){
				if(!set.add(str)){
					return false;
				}
				return true;
			}else{
				if(check[idx].equals(str)){
					return true;
				}else{
					return false;
				}
			}
		}else{
			for(int end = 1; end <= str.length()-(pattern.length()-1); end++){
				String cur = str.substring(0, end);
				if(check[idx] == null){
					if(!set.add(cur)){
						continue;
					}
					check[idx] = cur;
					if(PatternSearch(pattern.substring(1), str.substring(end), check, set)){
						return true;
					}
					check[idx] = null;
					set.remove(cur);
				}else{
					if(check[idx].equals(cur)){
						if(PatternSearch(pattern.substring(1), str.substring(end), check, set)){
							return true;
						}
					}else{
						continue;
					}
				}
			}
		}
		return false;
		
	}
	
}
