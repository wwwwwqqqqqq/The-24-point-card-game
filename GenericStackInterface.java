package TwentyFourPointsCardGame;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Specifications on the design of GenericStack. 
 * @author Qin Weiwei
 * @version 1.0
 */
public interface GenericStackInterface<E>{
	/**
	 * Construct an empty stack.
	 */
	public void GenericStack();
	
	/**
	 * Return the size of the list.
	 */
	public int getSize();
	
	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 */
	public E peek();
	
	/**
	 * Pushes an item onto the top of this stack.
	 */
	public void push(E o);
	
	/**
	 * Removes the object at the top of this stack and returns that object as the value of this function.
	 */
	public E pop();
	
	/**
	 * Tests if this stack is empty.
	 * @return A value of boolean
	 */
	public boolean isEmpty();
}
	
