import java.util.Arrays;
/**
    A class of stacks whose entries are stored in an array.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.0
*/
public final class ResizeableArrayStack<T> implements StackInterface<T>
{
	private T[] stack;    // Array of stack entries
	private int topIndex; // Index of top entry
   private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
  
   public ResizeableArrayStack()
   {
      this(DEFAULT_CAPACITY);
   }
  
   public ResizeableArrayStack(int initialCapacity)
   {
      integrityOK = false;
      checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempStack = (T[])new Object[initialCapacity];
      stack = tempStack;
		topIndex = -1;
      integrityOK = true;
  }

   public void push(T newEntry)
   {
      checkIntegrity();
      ensureCapacity();
      stack[topIndex + 1] = newEntry;
      topIndex++;
   }

   private void ensureCapacity()
   {
      if (topIndex >= stack.length - 1) // If array is full, double its size
      {
         int newLength = 2 * stack.length;
         checkCapacity(newLength);
         stack = Arrays.copyOf(stack, newLength);
      }
   }

   public T pop()
   {
      checkIntegrity();
      if (isEmpty())
         try {
            throw new IllegalStateException("Attempted to pop from empty stack.");
         } catch (IllegalStateException ex) {
            return null;
         }
      else
      {
         T top = stack[topIndex];
         stack[topIndex] = null;
         topIndex--;
         return top;
      }
   }

   public T peek()
   {
      checkIntegrity();
      if (isEmpty())
         try {
            throw new IllegalStateException("Attempted to peek inside empty stack.");
         } catch (IllegalStateException ex) {
            return null;
         }
      else
         return stack[topIndex];
   }

   public boolean isEmpty()
   {
      return topIndex < 0;
   }
   
   public void clear()
   {
      checkIntegrity();
      
      // Remove references to the objects in the stack,
      // but do not deallocate the array
      while (topIndex > -1)
      {
         stack[topIndex] = null;
         topIndex--;
      }
      //Assertion: topIndex is -1
   }

   private void checkCapacity(int newLength)
   {
      if (newLength > MAX_CAPACITY)
         throw new IllegalStateException("Attempted to create stack with capacity greater than " + MAX_CAPACITY);
   }

   // Throws an exception if this object is not initialized.
   private void checkIntegrity()
   {
      if (!integrityOK)
         throw new SecurityException("ArrayBag object is corrupt.");
   }

   private static int eval(char op, int a, int b) 
   {
      
      int result = -1;
      if (op == '+')
         return a + b;
      else if (op == '-')
         return a - b;
      else if (op == '*')
         return a * b;
      else if (op == '/')
         return a / b;
      else if (op == '^')
         return (int) Math.pow(a, b);
      return result;
  }

   //Evaluates a postfix expression
   public int evaluatePostfix(String postfix) {
      ResizeableArrayStack<Integer> valueStack = new ResizeableArrayStack<Integer>(postfix.length());

      //for (int i = 0; i < postfix.length(); i++)
      int i = 0;
      while (i < postfix.length()) //Postfix has characters left to parse
      {
         char nextCharacter = postfix.charAt(i);
         switch (nextCharacter)
         {
            case 'a' :
               valueStack.push(2);
               break;
            case 'b' :
               valueStack.push(3);
               break;
            case 'c' :
               valueStack.push(4);
               break;
            case 'd' :
               valueStack.push(5);
               break;
            case 'e' :
               valueStack.push(6);
               break;
            case '+' : case '-' : case '*' : case '/' : case '^' :
               int operandTwo = (int)valueStack.pop();
               int operandOne = (int)valueStack.pop();
               int result = eval(nextCharacter, operandOne, operandTwo); //The result of the operation in nextCharacter and its operands
               valueStack.push(result);
               break;
            default: break; //Ignore unexpected characters
         }
         i++;
      }
      return valueStack.peek();
   }
}