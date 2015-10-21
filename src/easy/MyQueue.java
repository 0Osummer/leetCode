package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyQueue {
	
	Stack<Integer> myQueue = new Stack<>();
	
	// Push element x to the back of queue.
    public void push(int x) {
        List<Integer> a = new ArrayList<>();
        while(!this.empty()){
        	a.add(myQueue.pop());
        }
        myQueue.push(x);
        for(int i = a.size()-1; i >= 0; i--){
        	myQueue.push(a.get(i));
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        myQueue.pop();
    }

    // Get the front element.
    public int peek() {
        return myQueue.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return myQueue.empty();
    }

}
