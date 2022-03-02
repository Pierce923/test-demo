package cc.fivelong;

/**
 * char
 */
public class T012_Char {

    public static void main(String[] args) {
        char c = 'c';
        System.out.println(c);

        char[] cc = new char[5];
        cc[0] = 'a';
        cc[1] = 'b';
        cc[2] = 'c';
        System.out.println(cc);

        // String转char
        stringToChar();

        // char + 整数 结果为整数值
        System.out.println('c' + 100.2);

    }

    // String转char
    private static void stringToChar() {
        // String转char
        String a = "a";
        char[] chars = a.toCharArray();
        System.out.println("String转char---->" + chars);
    }

}
