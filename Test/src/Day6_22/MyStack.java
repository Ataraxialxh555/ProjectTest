package Day6_22;

class MyStack {
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



    public void push(Object obj) throws MyStackOperationException {
        if(this.index >= this.elements.length-1){
//            System.out.println("栈已满，压栈失败！！");
//            return;

            //使用异常
//            MyStackOperationException e = new MyStackOperationException("栈已满，压栈失败！");
//            throw e;
            //方法2
            throw new MyStackOperationException("栈已满，压栈失败！！");
        }
        this.index++;
        this.elements[index] = obj;
        System.out.println("压栈"+obj+"元素成功，栈帧指向---->"+index);
    }

    public void pop() throws MyStackOperationException {
        if(this.index < 0){
//            System.out.println("栈已空，弹栈失败！！！");
//            return;
            throw new MyStackOperationException("栈已空，弹栈失败！");
        }
        System.out.println("弹栈"+this.elements[index]+"元素成功，栈帧指向---->"+(--index));
    }
}