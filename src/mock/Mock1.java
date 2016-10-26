package mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static void test35() {
        Base11<Number> b = new Base11<Number>();
//        Base11<Number> b1 = new Derived11<Number>();
//        Base11<Number> b2 = new Derived11<Integer>();
//         Derived11<Number> b3 = new Derived11<Integer>();
//         Base11<Integer> b4 = new Derived11<Integer>();
         Derived11<Integer> b5 = new Derived11<Integer>();
    }

    public static void test36() {
        Base11<? extends Number> b = new Base11<Number>();
//        Base11<? extends Number> b1 = new Derived11<Number>();
//        Base11<? extends Number> b2 = new Derived11<Integer>();
        Derived11<? extends Number> b3 = new Derived11<Integer>();
//        Base11<?> b4 = new Derived11<Integer>();
        Derived11<?> b5 = new Derived11<Integer>();

    }

    public static void test38() {
        Set<Integer> set = new LinkedHashSet<Integer>(); //#1
//        LinkedHashSet<Integer> set2 = new HashSet<Integer>(); //#2
        SortedSet<Integer> set3 = new TreeSet<Integer>(); //#3
//        SortedSet<Integer> set4 = new NavigableSet<Integer>(); //#4
    }
    public static void test39() {
        Set<Integer> set = new TreeSet<Integer>();
        set.add(5);
        set.add(10);
        set.add(3);
        set.add(5);
        set.add(null);
        System.out.println(set);
    }
    public static void test41() {
//        Map<String, int> map =         new HashMap<int, String>(); //#1
        Map<String, String> map2 =
                new HashMap<String, String>(); //#2
        Map<String, String> map3 = new HashMap<>(); //#3
//        Map<> map4 = new HashMap<String, String>(); //#4
    }
    public static void test42() {
        Map<Integer, String> map = new TreeMap<Integer, String>();
        map.put(5, "5");
        map.put(10, "10");
        map.put(3, "3");
        map.put(5,"25");
        System.out.println(map);

    }

    public static void test43(){
        Deque<Integer> deque = new LinkedList<>();
        deque.add(10);
        deque.add(20);
        deque.peek();
        deque.peek();
        deque.peek(); //#1
        System.out.println(deque);
    }

    public static void test45(){
        HashSet<Student> students = new HashSet<>();
        students.add(new Student(5));
        students.add(new Student(10));
        System.out.println(students.contains(new Student(5)));
    }

    public static void test47(){
        HashSet<Student> students = new HashSet<>();
        students.add(new Student(5));
        Student s10 = new Student(10);
        students.add(s10);
        System.out.println(students.contains(new Student(10)));
        System.out.println(students.contains(s10));
    }

    public static void test49(){
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        List list = intList;
        list.add("hello");
        list.add(new Base());

        for(Object o : list) {
            System.out.print(o + " ");
        }
    }

    public static void test50(){
//        Map<String, String> map1 = new NavigableMap<>();
         Map<String, String> map2 = new IdentityHashMap<>();
         Map<String, String> map3 = new Hashtable<>();
//         Map<String, String> map4 = new ConcurrentMap<>();
    }

    public static void test999(){
        long a = (long) (Math.pow(2147483647,2147483647)%46340);
        System.out.println(a);
    }

    public static void test51() {
        String hello = "hello";
        String world = "world";
        StringBuffer helloWorld = new StringBuffer(hello + world);
        List<String> list =
                Arrays.asList(hello, world, helloWorld.toString());
        helloWorld.append("!");
        list.remove(0); // REMOVE
        System.out.println(list);
    }

    public static void test52() {
        String s = new String("5");
        System.out.println(1+10+s+1+10);
    }
    public static void test53() {
        String s = new String("5");
        System.out.println(1.0+10.5+s+(1.0+10.5));
    }
    public static void test54() {
        System.out.printf("%7.6s %n", "hello world");
        System.out.printf("%05d", 123);
    }

    public static void test55(){
        String two = "2";
        System.out.println("1 + 2 + 3 + 4 = "
                + 1 + Integer.parseInt(two) + 3 + 4); // PARSE
    }

    public static void test56(){
        int a = 7, b = 10;
        System.out.printf("no:%2$s and %1$s", a, b);
        System.out.printf("\nno:2$s and 1$s", a, b);
    }
    public static void test57(){
        String quote = "aba*abaa**aabaa***";
        String [] words = quote.split("a\\**", 20);
        int l=words.length;
        System.out.println(l);
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static void test58(){
        String str1 = "xxzz";
        String str2 = "xyz";
        String str3 = "yzz";
        Pattern pattern = Pattern.compile("(xx)*y?z{1,}");
        Matcher matcher = pattern.matcher(str1);
        System.out.println(matcher.matches());
        System.out.println(pattern.matcher(str2).matches());
        System.out.println(
                Pattern.compile("(xx)*y?z{1,}").
                        matcher(str3).matches());
    }

    public static void test59(){
        String str = "OCPJP 2013 OCPJP7";
        Pattern pattern = Pattern.compile("\\w+\\D\\b");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()) {
            System.out.println(matcher.group());
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

class ConutryComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o2);
    }
}

class Sort{
    public static void main(String[] args) {
        String[] bric = {"Brazil","Russia","India","China"};
        Arrays.sort(bric,null);
        for (String c :
                bric) {
            System.out.println("c:"+c);
        }
    }
}

class ListFromVarargs {
    public static <T> List<T> asList1(T... elements) {
        ArrayList<T> temp = new ArrayList<>();
        for(T element : elements) {
            temp.add(element);
        }
        return temp;
    }
    public static <T> List<?> asList2(T... elements) {
        ArrayList<T> temp = new ArrayList<>();
        for(T element : elements) {
            temp.add(element);
        }
        return temp;
    }
    public static <T> List<?> asList3(T... elements) {
        ArrayList<T> temp = new ArrayList<>();
        for(T element : elements) {
            temp.add(element);
        }
        return temp;
    }
    public static <T> List<?> asList4(T... elements) {
        List<T> temp = new ArrayList<T>();
        for(T element : elements) {
            temp.add(element);
        }
        return temp;
    }
}

class TemplateType {
    public static void main(String []args) {
        List<Map<List<Integer>, List<String>>> list =
                new ArrayList<>(); // ADD_MAP
        Map<List<Integer>, List<String>> map = new HashMap<>();
        list.add(null); // ADD_NULL
        list.add(map);
        list.add(new HashMap<List<Integer>,
                        List<String>>()); // ADD_HASHMAP
        for(Map element : list) { // ITERATE
            System.out.print(element + " ");
        }
    }
}

class Base11<T extends Number> { }
class Derived11<T> { }

class Student{
    public Student(int r) {
        rollNo = r;
    }
    int rollNo;

    public int hashCode(){
        return rollNo;
    }
}
