package mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static java.lang.System.out;

public class Mock1 {

    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Chose test : ");
                String input = br.readLine();

                if ("q".equals(input)) {
                    System.out.println("Exit!");
                    System.exit(0);
                } else {
                    String m = "test" + input;
                    Method method = Mock1.class.getMethod(m);
                    method.invoke(Mock1.class);
                }

                System.out.println("input : " + input);
                System.out.println("-----------\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void test1() {
        int i = 012;
//        int i = 10.0f;
//        int i = 10L;
//        int i = 10.0;
        System.out.println(i);
        if (i == 10.0)
            System.out.println("true");
    }

    public static void test3() {
        StringBuffer sb = new StringBuffer("This is the hell.!");
        System.out.println(sb.replace(12, 17, "haven"));
    }

    public static void test4() {
        Object nullObj = null;
        StringBuffer sb = new StringBuffer(10);

        sb.append("hello ");
        sb.append("world ");
        sb.append(nullObj);
        sb.insert(11, "!");
        System.out.println(sb);
    }

    public static void test5() {
        Boolean b = null;
        System.out.println(b ? true : false);
    }

    public static void test6() {
        Der d = new DeriDer();
    }

    public static void test9(){
        Base b = new Der("Hello");
    }

    public static void test11(){
        out.print("Long");
    }
}

class Base {
    public Base() {
        System.out.println("base");
    }

    public Base(String s) {
        System.out.println("base: "+s);
    }
}

class Der extends Base {
    public Der() {
        System.out.println("der");
    }

    public Der(String s) {
//        super();
//        super(s);
        System.out.println("der");
    }
}

class DeriDer extends Der {

    public DeriDer() {
        System.out.println("DeriDer");
    }
}

class Point{
    private int x = 0,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    private Point() {
//        this(0,0);
//    }

//    public Point() {
//        this(x,0);
//    }

    public Point() {
//        System.out.println("sd");
        this(0,0);
//        super();

    }
}
