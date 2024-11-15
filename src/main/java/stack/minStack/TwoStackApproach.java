package stack.minStack;

import java.util.Stack;

public class TwoStackApproach {
	private Stack<Integer> stack;
	  private Stack<Integer> minStack;

	  public void MinStack() {
	      stack = new Stack<>();
	      minStack = new Stack<>();
	  }
	  
	  public void push(int val) {
	      stack.push(val);
	      // Push to minStack if the minStack is empty or val is less than or equal to current min
	      if (minStack.isEmpty() || val <= minStack.peek()) {
	          minStack.push(val);
	      }
	  }
	  //minStack only stores values that are currently the minimums in stack. When we remove a value from   
	  //stack that was also the minimum, we have to update minStack by popping from it as well.
	  public void pop() {
	      int removed = stack.pop();
	      // Pop from minStack if the removed element is the current minimum
	      if (removed == minStack.peek()) {
	          minStack.pop();
	      }
	  }
	  
	  public int top() {
	      return stack.peek();
	  }
	  
	  public int getMin() {
	      return minStack.peek();
	  }
}


