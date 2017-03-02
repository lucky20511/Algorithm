import java.util.*;
public class Solution {

	/*
	 * Method 1: Recursion DFS
	 * 
	 */
	
	public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }
    
    private int helper(List<NestedInteger> nestedList, int layer){
        int total = 0;
        for(NestedInteger i : nestedList){
            if(i.isInteger()){
                total += layer*i.getInteger();
            }else{
                total += helper(i.getList(), layer+1);
            }
        }
        return total;
    }
    
    
    /*
	 * Method 2: Iteration DFS
	 * 
	 */
    class Obj{
        List<NestedInteger> list;
        int layer;
        Obj(List<NestedInteger> ls, int num){
            list = ls;
            layer = num;
        }
    }
    
    public int depthSum(List<NestedInteger> nestedList) {
        Stack<Obj> stack = new Stack<Obj>();
        stack.push(new Obj(nestedList, 1));
        int sum = 0;
        while(!stack.isEmpty()){
             Obj obj = stack.pop();
             for(NestedInteger i : obj.list){
                 if(i.isInteger()){
                    sum += i.getInteger() * obj.layer;
                 }else{
                     stack.push(new Obj(i.getList(), obj.layer+1));
                 }
             }
        }
        return sum;
        
    }
    
    
    /*
	 * Method 3: Iteration BFS
	 * 
	 */
    
    class Obj{
        List<NestedInteger> list;
        int layer;
        Obj(List<NestedInteger> ls, int num){
            list = ls;
            layer = num;
        }
    }
    
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<Obj> queue = new LinkedList<Obj>();
        queue.offer(new Obj(nestedList, 1));
        int sum = 0;
        while(!queue.isEmpty()){
             Obj obj = queue.poll();
             for(NestedInteger i : obj.list){
                 if(i.isInteger()){
                    sum += i.getInteger() * obj.layer;
                 }else{
                     queue.offer(new Obj(i.getList(), obj.layer+1));
                 }
             }
        }
        return sum;
        
    }
    
    
    
	
}
