package FirstFeature;

public class Teacher implements Named,Person{


    @Override
    public String getName() {
        return getClass().getName();
    }


}
