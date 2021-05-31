package TwentyFourPointsCardGame;

import java.util.Stack;
//import java.util.*;
//import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.lang.RuntimeException;

//import java.util.ArrayList;
/**
 * A class that to store object in the stack.
 * @author Qin Weiwei
 * @version 1.0
 */
public class GenericStack<E> implements GenericStackInterface<E>{
	/**
	 * The list of objects of this stack
	 */
	private java.util.ArrayList<E> list;
	//private int top;
	//private String[] stackArray;
	
	/*StringTokenizer st = new StringTokenizer("this is a test");
    while (st.hasMoreTokens()) {
        System.out.println(st.nextToken());
    }*/
	
	/**
	 * Constructor of the class.
	 */
	public GenericStack(){
	    list = new ArrayList<>();
	}
	
	/**
	 * Construct an empty stack.
	 */
	public void GenericStack(){
	    list = new ArrayList<>();
	}
	
	/**
	 * Return the size of the list.
	 */
	public int getSize() {
		return this.list.size();
	}
	
	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 */
	public E peek() throws EmptyStackException{
		//this.list.get(list.size() - 1);
		/*System.out.println(this.list.get(list.size() - 1));
		return this.list.get(list.size() - 1);*/
		//return (E)stackArray[top];
		/*System.out.println(this.list.get(list.size() - 1));
		return this.list.get(getSize() - 1);*/
		if(getSize() <= 0) {
			throw new EmptyStackException();
		}
		else if(getSize() > 0) {
			return this.list.get(getSize() - 1);
		}
		return null;
	}
	
	/**
	 * Pushes an item onto the top of this stack.
	 */
	public void push(E o) {
		list.add(getSize(),o);
		//stackArray[++ top] = ;
		//return (int) this.list.get(list.size() + 1);
	}
	
	/**
	 * Removes the object at the top of this stack and returns that object as the value of this function.
	 */
	public E pop() throws EmptyStackException{
		if(getSize() > 0) {
			E a = this.list.get(getSize() - 1);
			this.list.remove(getSize() - 1);
			return a;
		}
		else
			return null;
		//System.out.println("The size of the list is " + getsize);
		/*E a = (E) stackArray[top --];
		return a;*/
	}
	
	/**
	 * Tests if this stack is empty.
	 * @return A value of boolean
	 */
	public boolean isEmpty() {
		if(getSize() == 0) {
			return true;
		}
		return false;
	}
}
