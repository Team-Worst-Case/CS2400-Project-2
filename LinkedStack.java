import java.util.EmptyStackException;
/**
    A class of stacks whose entries are stored in a chain of nodes.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.0
*/
public final class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode; // References the first node in the chain
  
   public LinkedStack()
   {
      topNode = null;
   }
   public void push(T newEntry)
   {
      topNode = new Node(newEntry, topNode);
   }

   public T pop()
   {
      T top = peek();  // Might throw EmptyStackException
      // Assertion: topNode != null
      topNode = topNode.getNextNode();
      return top;
   }

   public T peek()
   {
      if (isEmpty())
         throw new EmptyStackException();
      else
         return topNode.getData();
   }

   public boolean isEmpty()
   {
      return topNode == null;
   }
   
   public void clear()
   {
      topNode = null;
   }

	private class Node
	{
      private T    data; // Entry in stack
      private Node next; // Link to next node
      
      private Node(T dataPortion)
      {
         this(dataPortion, null);
      }
      
      private Node(T dataPortion, Node linkPortion)
      {
         data = dataPortion;
         next = linkPortion;
      }
      
      private T getData()
      {
         return data;
      }
      
      private void setData(T newData)
      {
         data = newData;
      }
      
      private Node getNextNode()
      {
         return next;
      }
      
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      }
	}
}

   class InfixToPostfix {//InfixToPostfix class
   
      private static int getPriority(char c) //method needed to return priority of an operator
      {
         switch(c)
         {
            case '(': return 0;
            case '/': case '*': return 2;
            case '+': case '-': return 1;
            default: return 999;
         }
      }


   public static String convertToPostfix(String infix) throws Exception{
      infix = infix + ")";

      //create an object of LinkedStack class
      LinkedStack<Character> stk = new LinkedStack<Character>();

      stk.push('(');

      String postfix = "";

      //convert from infix to postfix
      for(int i = 0; i < infix.length(); i++)
      {
         char ch = infix.charAt(i);

         if(Character.isLetter(ch)) // check for variable
         {
            postfix = postfix + ch + " ";
         }
         
         else if(ch == '(')   //check for left parenthesis
         {
            stk.push(ch);
         }

         else if (ch == ')')  //check for right parenthesis
         {
            while(stk.peek() != '(')
            {
               postfix = postfix + stk.peek() + " ";
               stk.pop();
            }
            stk.pop();
         }

         //operator
         else
         {
            int p1 = getPriority(ch);
            int p2 = getPriority(stk.peek());

            while(p1 <= p2)
            {
               postfix = postfix + stk.peek() + " ";
               stk.pop();
               p2 = getPriority(stk.peek());

            }
            stk.push(ch);
         }
      }
            if(!stk.isEmpty()) //error check
            System.out.println("Invalid expression");

            return postfix;   //return postfix expression
         }

            
      
      
   }

