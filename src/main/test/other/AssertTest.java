package other;

/**
 * @author FaceFeel
 * @Created 2018-01-21 12:43
 */

public class AssertTest {

//    public static void main(String[] args) {
//
//        int i = 0;
//        for (i = 0; i < 5; i++) {
//            System.err.println(i);
//        }
//        i--;
//        assert i == 5;
//    }

    public static void main(String[] args) throws Exception {
        String str = "我a爱中华abc我爱木木def";
//        String str = "我 ABC 汉";

        new String(str.getBytes("UTF-8"),"UTF-8");
        int num = trimGBK(str.getBytes("GBK"), 10);
        System.out.println(str.substring(0, num));
    }

    public static int trimGBK(byte[] buf, int n) {
        int num = 0;
        boolean bChineseFirstHalf = false;
        for (int i = 0; i < n; i++) {
            if (buf[i] < 0 && !bChineseFirstHalf) {
                bChineseFirstHalf = true;
            } else {
                num++;
                bChineseFirstHalf = false;
            }
        }
        return num;
    }
}
