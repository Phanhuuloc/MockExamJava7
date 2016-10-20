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

//                System.out.println("input : " + input);
                System.out.println("\n-----End of Mock test" + input + "------\n");
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

    public static void test9() {
        Base b = new Der("Hello");
    }

    public static void test11() {
        out.print("Long");
    }

    public static void test13() {
        Base b = new Base1();
        ((Base2)b).test();
    }

    public static void test14() {
        Outer.Inner inner = new Outer().new Inner();
    }

    public static void test16() {
        if(AnEnum.ONLY_MEM instanceof AnEnum){
            System.out.println("Yes 1");
        }
        if(AnEnum.ONLY_MEM instanceof Enumbase){
            System.out.println("Yes 2");
        }
        if(AnEnum.ONLY_MEM instanceof Enum){
            System.out.println("Yes 3");
        }
    }
}

class Base {

    public Base() {
//        System.out.println("base");
    }

    public Base(String s) {
        System.out.println("base: " + s);
    }

    public void test(){
        System.out.println("Base");
    }
}

class Base1 extends Base{
    @Override
    public void test() {
        System.out.println("base1");
    }
}

class Base2 extends Base{
    @Override
    public void test() {
        System.out.println("base2");
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

class Point {
    private int x = 0, y;

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
        this(0, 0);
//        super();

    }
}

class Outer{
    private int mem =10;
    class Inner{
        private int imem = new Outer().mem;
        public void print(){
            System.out.println("inner");
        }
    }

    public static void main(String[] args) {
        System.out.println(new Outer().new Inner().imem);
    }
}

interface Enumbase{}
abstract class EnumExtend{

}
enum AnEnum implements Enumbase{
    ONLY_MEM;

//    private String aaa;
//    private AnEnum() {
//    }
//
//    private void method(){
//
//    }
}

class base1{
    protected int var;
}

interface base2{
    int var = 2;
}

class Test extends base1 implements base2{
    public static void main(String[] args) {
//        base1 b =new Test();
        System.out.println("var"+base2.var);
    }
}

class WildCard{
    interface BI{}
    interface DI extends BI{}
    interface DDI extends DI{}

    static class C<T>{}
    static void foo(C<? super DI> arg){}

    public static void main(String[] args) {
        foo(new C<BI>());
        foo(new C<DI>());
//        foo(new C<DDI>());
        foo(new C());
    }
}