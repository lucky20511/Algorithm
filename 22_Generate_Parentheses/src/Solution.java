import java.util.*;

public class Solution {
	
	public static void main(String[] args){
		
		Solution sol = new Solution();
		System.out.println(sol.generateParenthesis(5));
		
	}
	
	
	/*
	 * Method I.   Recursion DFS
	 */
	
//	public List<String> generateParenthesis(int n) {
//        int l = 0, r = 0;
//        List<String> list = new ArrayList<String>();
//        helper(list, l, r, "", n);
//        return list;
//    }
//    
//    private void helper(List<String> list, int left, int right, String s, int n){
//        if(right == n){
//            list.add(s);
//            return;
//        }
//        
//        if(left > right){
//            helper(list, left, right+1, s+")", n);
//        }
//        if(left < n){
//            helper(list, left+1, right, s+"(", n);
//        }
//    } 
	
    /*
	 * Method II.   Iteration DFS
	 */
//	class Obj{
//		int left;
//		int right;
//		String str;
//		Obj(int l, int r, String s){
//			left = l;
//			right = r;
//			str = s;
//		}
//	}
//    
//    
//	public List<String> generateParenthesis(int n) {
//        
//		List<String> list = new ArrayList<String>();
//		Stack<Obj> stack = new Stack<Obj>();
//		stack.push(new Obj(0, 0, ""));
//		while(!stack.isEmpty()){
//			Obj obj = stack.pop();
//			if(obj.right == n){
//				list.add(obj.str);
//			}else{
//				if(obj.left > obj.right){
//					stack.push(new Obj(obj.left, obj.right+1, obj.str+")"));
//				}
//				if(obj.left < n){
//					stack.push(new Obj(obj.left+1, obj.right, obj.str+"("));
//				}
//			}
//		}
//        return list;
//        
//    }
	
	
	/*
	 * Method II.   Iteration BFS
	 */
	class Obj{
		int left;
		int right;
		String str;
		Obj(int l, int r, String s){
			left = l;
			right = r;
			str = s;
		}
	}
    
    
	public List<String> generateParenthesis(int n) {
        
		List<String> list = new ArrayList<String>();
		Queue<Obj> queue = new LinkedList<Obj>();
		queue.offer(new Obj(0, 0, ""));
		while(!queue.isEmpty()){
			Obj obj = queue.poll();
			if(obj.right == n){
				list.add(obj.str);
			}else{
				if(obj.left > obj.right){
					queue.offer(new Obj(obj.left, obj.right+1, obj.str+")"));
				}
				if(obj.left < n){
					queue.offer(new Obj(obj.left+1, obj.right, obj.str+"("));
				}
			}
		}
        return list;
        
    }
	
	
}
