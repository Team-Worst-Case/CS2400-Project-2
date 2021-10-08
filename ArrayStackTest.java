

public class ArrayStackTest{
    public static void main(String[] args){

        ResizeableArrayStack <Integer> stack1 = new ResizeableArrayStack <Integer>();

        // System.out.println(stack1.evaluatePostfix("a*b/(c-a)+d*e"));
        
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
        System.out.println("Peek Test After Clear (Should throw exception): " + stack1.peek());



    }
}