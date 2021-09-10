package Day6_22;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack  myStack = new MyStack();
        for (int i = 0; i < 11; i++) {
            try {
                myStack.push(new Object());
            } catch (MyStackOperationException e) {
//                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }

        for (int i = 0; i < 11; i++) {
            try {
                myStack.pop();
            } catch (MyStackOperationException e) {
//                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
}
