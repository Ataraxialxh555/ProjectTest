package java1;


import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        // ����Optional
        String mayBeNull = null;
        Optional<String> opt1 = Optional.of(" Hello! ");
        Optional<String> opt2 = Optional.ofNullable(mayBeNull);
        Optional<String> opt3 = Optional.empty();
        opt1.ifPresent(System.out::println); // " Hello! "
        System.out.println();
        opt2.ifPresent(System.out::println);
        System.out.println();
        opt3.ifPresent(System.out::println);
        System.out.println();

        //��������ʾ��
        ofTest();
        System.out.println();
        ofNullableTest();
        System.out.println();
        isPresentTest();
        System.out.println();
        ifPresentTest();
        System.out.println();
        orElseTest();
        System.out.println();
        orElseGetTest();
        System.out.println();
        mapTest();
        System.out.println();
        flatMapTest();
        System.out.println();
        filterTest();
        System.out.println();

    }

    /**
     * of����Ӹ�optional���õ�ֵ ���ǲ���Ϊ�� ���Ϊ�ջᱨ��ָ���쳣
     */
    public static void ofTest() {
        Optional<String> optional = Optional.of("123");
        System.out.println(optional.get());
        try {
            optional = Optional.of(null);
            System.out.println("nullֵ--" + optional.get());  //get�����ǻ�ȡoptional��ֵ ����ȡ����������ʱ��
        } catch (NullPointerException e) {
            System.out.println("��ָ���쳣");
        }
    }

    /**
     * ofNullable ��of���� ����ofNullable��������nullֵ  �����Nullֵ�û�ȡֵ�ᱨNoSuchElementException �쳣
     */
    public static void ofNullableTest() {
        Optional<String> optional = Optional.ofNullable("123");
        System.out.println(optional.get());
        try {
            optional = Optional.ofNullable(null);
            System.out.println("nullֵ---" + optional.get()); //get() optional������Ϊ��
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException �쳣");
        }
    }

    /**
     * ifPresent�����ж�optional����û��ֵ���� �������Ϊ��
     */
    public static void isPresentTest() {
        Optional<String> optional = Optional.ofNullable(null);
        if (optional.isPresent()) { //false û��ֵ ��ִ��else���
            System.out.println(optional.get());
        } else {
            System.out.println("ֵΪ��");
        }
    }

    /**
     * ifPresent��isPresent���� ֻ������֧�֦˱��ʽ
     */
    public static void ifPresentTest() {
        Optional<String> optional = Optional.ofNullable("123");
        optional.ifPresent(var -> {
            System.out.println(var);
        });
    }

    /**
     * orElse���������ֵΪ�յĻ����ò����е�ֵȥ�滻 ������Ĭ��ֵ
     */
    public static void orElseTest() {
        Optional<String> optional = Optional.ofNullable("123");
        System.out.println(optional.orElse("��û��"));
        optional = Optional.ofNullable(null);
        System.out.println(optional.orElse("��û��000"));
    }

    /**
     * orElseGet���� ��orElse���� �����˷�������Supplier�ӿڵ�ʵ����������Ĭ��ֵ
     *
     */
     /*  public interface Supplier<T> {
        T get();
    }*/
    public static void orElseGetTest() {

        Optional<String> optional = Optional.ofNullable("123");
        System.out.println(optional.orElseGet(() -> "123456"));
        optional = Optional.ofNullable(null);
        System.out.println(optional.orElseGet(() -> "1234567"));
    }

    /**
     * map����  �����ֵ����ֵ����mapping�еĴ��� �����������򴴽�������Optional���͵Ľ�� ���򷵻ؿ�
     */
    public static void mapTest() {
        Optional<String> optional = Optional.ofNullable("abc");
        System.out.println(optional.map(var -> var.toUpperCase()).get());
    }

    /**
     * flatMap��map���� ֻ����mapping�б��뷵��Option���͵�����
     */
    public static void flatMapTest() {
        Optional<String> optional = Optional.ofNullable("abc");
        System.out.println(optional.flatMap(var -> Optional.of(var.toUpperCase())).get());
    }

    /**
     * filter��optional���й���,mapping��Ϊ���˵�����  ������������� ����һ��Ϊ�յ�Optional
     */
    public static void filterTest() {
        try {
            Optional<String> optional = Optional.ofNullable("һ�����������߰�");
            System.out.println(optional.filter(var -> var.length() > 6).get());
            System.out.println(optional.filter(var -> var.length() < 6).get());  //(var -> var.length() < 6)���ؽ��ΪNULL����ִ��catch���
        } catch (NoSuchElementException e) {
            System.out.println("optional��ֵΪ��");
        }
    }

}

