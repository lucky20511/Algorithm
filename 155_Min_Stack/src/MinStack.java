import java.util.*;

public class MinStack {
	
	public static void main(String[] args){
		MinStack minStack = new MinStack();
		minStack.push(-1);
		minStack.push(-2);
		minStack.push(3);
		System.out.println(minStack.getMin() + " " + minStack.top());
		minStack.pop();
		System.out.println(minStack.getMin() + " " + minStack.top());
		minStack.pop();
		System.out.println(minStack.getMin() + " " + minStack.top());
		minStack.pop();
		System.out.println(minStack.getMin() + " " + minStack.top());
		
	}
	
	
	
	private Stack<Element> stack;
	
	class Element{
		int val;
		int min;
	}
	
	public MinStack(){
		stack = new Stack<Element>();
	}
	
	
	public void push(int x){
		Element element = new Element();
		element.val = x;
		if(!stack.isEmpty()){
			element.min = Math.min(x, stack.peek().min);
		}else{
			element.min = x;
		}
		stack.push(element);
	}
	
	public void pop(){
		stack.pop();
	}
	
	public int top(){
		if(!stack.isEmpty()){
			return stack.peek().val;
		}else{
			return Integer.MIN_VALUE;
		}
	}
	
	public int getMin(){
		if(!stack.isEmpty()){
			return stack.peek().min;
		}else{
			return Integer.MIN_VALUE;
		}
	}
	
	
	
}
