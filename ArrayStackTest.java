

public class ArrayStackTest{
    public static void main(String[] args){

        ResizeableArrayStack <Integer> stack1 = new ResizeableArrayStack <Integer>(2);

        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);

        stack1.pop();
        stack1.pop();
        stack1.peek();

    }
}