package other;

/**
 * @author FaceFeel
 * @Created 2018-01-22 18:22
 */

public class ExamTest {

    static {
        int f = 10;
    }

    static int fa = 12;

    public void intr() {

        fa = 13;
        System.err.println(fa);
    }

    public static void main(String[] args) {

        String string="zyx";
        string.toUpperCase();
         

        Integer integer1 = new Integer(12);
        Integer integer2 = new Integer(12);
        System.err.println(integer1 == integer2);

        int k = 0;
        Integer integer = new Integer(0);
        System.err.println(k == integer);


//        try {
//            System.err.println("123");
//            int k = 0;
//            i = 1 / i;
////            System.exit(0);
//            System.err.println("456");
//        } catch (Exception e) {
//            System.err.println("789");
//            System.exit(0);
//        } finally {
//            System.err.println("852");
//        }

        ExamTest examTest = new ExamTest();
        examTest.intr();
        int i = 0;
        examTest.fermin(i);
//        i = i++;
        i = ++i;
        System.err.println(i);
        String aba = "fdafa" + new String("he");
        System.err.println(aba);
    }

    void fermin(int i) {
        i++;
    }

    static{
        String aa = "";
    }
}
