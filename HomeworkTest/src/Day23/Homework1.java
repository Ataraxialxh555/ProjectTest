package Day23;

public class Homework1 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push("abc");
        myStack.push(222);
        myStack.push("333a");
        myStack.push("444a");
//        for (int i = 0; i < myStack.getElements().length; i++) {
//            System.out.println(myStack.getElements()[i]);
//        }

        System.out.println("=====================");
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();



//        for (int i = 0; i < myStack.getElements().length; i++) {
//            System.out.println(myStack.getElements()[i]);
//        }

    }
}

class MyStack{
    private Object[] elements;
    private int index;
    public MyStack() {
        this.elements = new Object[10];
        this.index = -1;
    }

    public MyStack(Object[] elements) {
        this.elements = elements;
    }

    public Object[] getElements() {
        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }



    public void push(Object obj){
        if(this.index >= this.elements.length){
            System.out.println("栈已满，压栈失败！！");
            return;
        }
        this.index++;
        this.elements[index] = obj;
        System.out.println("压栈"+obj+"元素成功，栈帧指向---->"+index);
    }

    public void pop(){
        if(this.index < 0){
            System.out.println("栈已空，弹栈失败！！！");
            return;
        }
        System.out.println("弹栈"+this.elements[index]+"元素成功，栈帧指向---->"+(--index));
    }
}