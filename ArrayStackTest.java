public class ArrayStackTest{
    public static void main(String[] args)
    {
        ResizeableArrayStack <Integer> stack1 = new ResizeableArrayStack <Integer>();

        System.out.println("evaluatePostfix Test 1: " + stack1.evaluatePostfix("ae+bd-/"));
        System.out.println("evaluatePostfix Test 2: " + stack1.evaluatePostfix("abc*d*-"));
        System.out.println("evaluatePostfix Test 3: " + stack1.evaluatePostfix("abc-ld*"));
        System.out.println("evaluatePostfix Test 4: " + stack1.evaluatePostfix("ebca^*+d-"));
        
        stack1.push(2);
        stack1.push(3);
        System.out.println("Peek Test: " + stack1.peek());
        
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);
        System.out.println("Peek Test 2: " + stack1.peek());

        System.out.println("Pop Test 1: " + stack1.pop());
        System.out.println("Pop Test 2: " + stack1.pop());

        System.out.println("Peek Test 3: " + stack1.peek());

        stack1.clear();
        System.out.println("Peek Test After Clear: " + stack1.peek());
    }
}