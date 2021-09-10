package Day6_3;

public class GetBytesTest {
    public static void main(String[] args) {
        byte[] bytes = "abcdef".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
    }
}
