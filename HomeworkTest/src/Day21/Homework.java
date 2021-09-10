package Day21;

public class Homework {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        InsertDrawable keyboard= new Keyboard();
        notebook.setName("宏碁");
        notebook.setInsert(keyboard);
        notebook.setRam(512);
        notebook.setSize(15.6);
        notebook.setRunningMemory(8);
        keyboard.plug();
        String result = notebook.toString();
        System.out.println(result);
    }
}
class Notebook{
    private String name;
    private int ram;
    private int runningMemory;
    private double size;
    private InsertDrawable insert;

    public Notebook() {
    }

    public Notebook(String name, int ram, int runningMemory, double size, InsertDrawable insert) {
        this.name = name;
        this.ram = ram;
        this.runningMemory = runningMemory;
        this.size = size;
        this.insert = insert;
    }

    public InsertDrawable getInsert() {
        return insert;
    }

    public void setInsert(InsertDrawable insert) {
        this.insert = insert;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRunningMemory() {
        return runningMemory;
    }

    public void setRunningMemory(int runningMemory) {
        this.runningMemory = runningMemory;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "name='" + name + '\'' +
                ", ram=" + ram +
                ", runningMemory=" + runningMemory +
                ", size=" + size +
                ", insert=" + insert +
                '}';
    }
}