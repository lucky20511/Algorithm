import java.util.*;
public class Solution {

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
	
}
