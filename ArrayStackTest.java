public class ArrayStackTest
{
    public static void main(String[] args)
    {
        ResizeableArrayStack <Integer> stack1 = new ResizeableArrayStack <Integer>();

        System.out.println("evaluatePostfix Test 1: ae+bd-/     = " + stack1.evaluatePostfix("ae+bd-/"));
        System.out.println("evaluatePostfix Test 2: abc*d*-     = " + stack1.evaluatePostfix("abc*d*-"));
        System.out.println("evaluatePostfix Test 3: abc-ld*     = " + stack1.evaluatePostfix("abc-ld*"));
        System.out.println("evaluatePostfix Test 4: ebca^*+d-   = " + stack1.evaluatePostfix("ebca^*+d-"));
        System.out.println("evaluatePostfix Test 5: ab*ca-/de*+ = " + stack1.evaluatePostfix("ab*ca-/de*+"));
        
        stack1.push(2);
        stack1.push(3);
        System.out.println("Peek Test (3):                        " + stack1.peek());
        
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);
        System.out.println("Peek Test 2 (6):                      " + stack1.peek());

        System.out.println("Pop Test 1 (6):                       " + stack1.pop());
        System.out.println("Pop Test 2 (5):                       " + stack1.pop());

        System.out.println("Peek Test 3 (4):                      " + stack1.peek());

        stack1.clear();
        System.out.println("Peek Test After Clear (null):         " + stack1.peek());
    }
}