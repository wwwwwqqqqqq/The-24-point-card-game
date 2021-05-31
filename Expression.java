package TwentyFourPointsCardGame;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * A class that implements the program.
 * @author Qin Weiwei
 * @version 1.0
 */
//Note: No Static methods. Otherwise, no credits.
public class Expression{
	private String infix;
	
	//Create a stack of type of string.
	private GenericStack<String> ops;
	//Create a stack of type of int.
	private GenericStack<Integer> num;
	
	//Create an empty array object list postfix, used to store the data in the type of string.
	private ArrayList<String> postfix;
	
	/**
	 * Constructor of the class.
	 */
	public Expression() {
		this.infix = "";
	}
	
	/**
	 * Constructor of the class.
	 * @param infix The input formula in the type of string.
	 */
	public Expression(String infix) {
		this.infix = infix;
	}
	
	/**
	 * Construct a method to change the input infix to postfix.
	 * @return A string of characters in the type of postfix.
	 */
	public ArrayList<String> infixToPostfix(){
		this.postfix = new ArrayList<>();
		ops = new GenericStack<>();
		StringTokenizer st = new StringTokenizer(this.infix,"+-/*()",true);
		/*String[] a = null;
		String b = "";
		GenericStack<String> stack = new GenericStack<String>();*/
	    while (st.hasMoreTokens()) {
	    	String ch = st.nextToken();
	    	switch(ch) {
			case "+":
			case "-":
				/**
				 * Determine whether meet the following conditions at the same time.
				 */
				while (!this.ops.isEmpty() && !this.ops.peek().equals("(")) {
							this.postfix.add(this.ops.pop());
						}
				/**
				 * Add the result to the stack.
				 */
				this.ops.push(ch);
				break;
			case "*":
			case "/":
				/**
				 * Determine whether meet the following conditions at the same time.
				 */
				while (!this.ops.isEmpty() && !this.ops.peek().equals("+") && !this.ops.peek().equals("-") && !this.ops.peek().equals("(")) {
					this.postfix.add(ops.pop());
				}
				/**
				 * Add the result to the stack.
				 */
				this.ops.push(ch);
				break;
			case "(":
				/**
				 * Add the result to the stack.
				 */
				this.ops.push(ch);
				break;
			case ")":
				/**
				 * Determine whether meet the following conditions.
				 */
				while (!this.ops.peek().equals("(")) {
					this.postfix.add(ops.pop());
				}
				/**
				 * Add the result to the stack.
				 */
				this.ops.pop();
				break;
			default:
				/**
				 * Add the result to the list.
				 */
				this.postfix.add(ch);
				break;
	    }
	    }
	    /**
	     * Determine whether the stack is empty
	     */
	    while(!this.ops.isEmpty()) {
	    	/**
	    	 * Add the result to the list.
	    	 */
	    	this.postfix.add(ops.pop());
	    }
	    return postfix;
	    
		/*for (int n = 0; n < a.length; n++) {
			String R = a[n];	         
			switch (R) {	            
			case "+": 	            
			case "-":
			while (!stack.isEmpty()) {	       	        
			String Top = stack.pop();
			if (Top.equals("(")) {	       	        	
				stack.push(Top);	       	            
				break;
				}	       	         
		    else {	       	            
				  int m;
			if (Top.equals("+") || Top.equals("-"))	       	            
				m = 1;	       	            
			else	       	            
				m = 2;	       	            
			if (m < 1) { 	       	            	
					stack.push(Top);	       	               
				break;
				}	       	            
			else	       	            
				b = b + Top;	       	         
				}	       	      
			}
			stack.push(R);	            
				break; 	            
				case "*": 	            
				case "/":
			while (!stack.isEmpty()) {	       	         
			    String Top = stack.pop();	       	         
			if (Top.equals("(")) {	       	        	
				stack.push(Top);	       	            
				break;
			}
			else {	       	            
				int m;	       	            
				if (Top.equals("+") || Top.equals("-"))	       	            
				m = 1;	       	            
			else	       	            
				m = 2;	       	            
			if (m < 2) { 	       	            	
				stack.push(Top);	       	               
				break;
				}	       	            
			else	       	            	
				b = b + Top;	       	         
				}	       	      
			}	            	
			stack.push(R);	            
				break; 
				case "(": 
					stack.push(R);	            
					break;
				case ")":
			while (!stack.isEmpty()) {	       	         
				String ch1 = stack.pop();	       	         
				if (ch1.equals("(")) 	       	         
				break; 	       	         
			else	       	        	
				b = b + ch1; 	       	      
			}	            
			    break;	            
				default: 	            	
			    b = b + R; 	            
				break;	         
			}	
	}
		while (!stack.isEmpty()) {	    	  
			b = b + stack.pop();
			}           
		return postfix;*/
}
	/**
	 * Calculating the value of postfix expression.
	 * @return the value of the postfix expression
	 */
	public int evaluatePostfix(){
		ArrayList<String> postfix = infixToPostfix();
		GenericStack<Integer> num = new GenericStack<>();
		//String[] a = this.infix.split("@");
	
		for(int i = 0;i < postfix.size();i ++) {
			/*if(Character.isDigit(a[i].charAt(0)))
			  {
				num.push(Integer.parseInt(a[i]));
			  }
			else if(a[i].equals("+")) {
				num.push(num.pop() + num.pop());
				}
			else if(a[i].equals("-")) {
				num.push(num.pop() - num.pop());
			}
			else if(a[i].equals("*")) {
				num.push(num.pop() * num.pop());
			}
			else if(a[i].equals("/")) {
				num.push(num.pop() / num.pop());
			}
			}*/
			/**
			 * Get the characters by loop.
			 */
			String node = postfix.get(i);
			switch(node) {
			/**
			 * If the symbol is "+".
			 */
			case "+":
				num.push(num.pop() + num.pop());
				break;
				
			/**
			 * If the symbol is "-".
			 */
			case "-":
				num.push(num.pop() - num.pop());
				break;
				
			/**
			 * If the symbol is "*".
			 */
			case "*":
				num.push(num.pop() * num.pop());
				break;
				
			/**
			 * If the symbol is "/".
			 */
			case "/":
				num.push(num.pop() / num.pop());
				break;
			default:
				//store the value at the type of integer in the stack
				num.push(Integer.parseInt(node));
				break;
			}
		}
		/**
		 * Return the value.
		 */
		return num.pop();
	}
}

