package FirstFeature;

public class SubTestImp implements SubInterface,DefaultInterface{
    @Override
    public void defaultMethod() {
        SubInterface.super.defaultMethod();
    }

    @Override
    public int sub(int a, int b) {
        return a-b;
    }
}
