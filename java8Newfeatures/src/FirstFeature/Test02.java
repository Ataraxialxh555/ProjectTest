package FirstFeature;

public class Test02 {
    public static void main(String[] args) {
        double[] values={2.0,2.5,6.3,1};
        double lar = max(values);
        System.out.println(lar);
        System.out.println(Double.NEGATIVE_INFINITY);
    }
    public static double max(double... values){
        double largest = Double.NEGATIVE_INFINITY;
        for(double b:values){
            if (b > largest) {
            largest = b;
            }
        }
        return largest;
    }
}
