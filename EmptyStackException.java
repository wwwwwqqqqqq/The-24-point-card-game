package TwentyFourPointsCardGame;

import java.lang.RuntimeException;

/**
 * Define an exception to be thrown when the stack is empty. 
 * @author Qin Weiwei
 * @version 1.0
 */
public class EmptyStackException extends RuntimeException{
		public EmptyStackException(String message) {
			super(message);
		}
}
