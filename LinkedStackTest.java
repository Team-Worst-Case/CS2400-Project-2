public class LinkedStackTest
{   
    public static void main(String[] args)
    {
        LinkedStack <String> stack1 = new LinkedStack <String>();

        String infix = "a*b/(c-a)+d*e";
        String postfix = stack1.convertToPostfix(infix);       //call the convertToPostfix method
        System.out.println ("Postfix expression: " + postfix);      //print postfix expression
    }
}