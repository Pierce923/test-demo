package cc.fivelong;

/**
 * StringBuffer和StringBuild区别
 */
public class T003_StringBufferBuild {

    public static void main(String[] args) {
        stringBuffer();
//        stringBuild();
    }

    private static void stringBuild() {
        StringBuilder sb = new StringBuilder();
        sb.append("aaa");
        sb.append("bbb");
        sb.append("ccc");
        sb.replace(0, 1, "m");
        System.out.println(sb.toString());
    }

    private static void stringBuffer() {
        StringBuffer sb = new StringBuffer();
        sb.append("aaa");
        sb.append("bbb");
        sb.append("ccc");
        sb.replace(0, 1, "m");
        System.out.println(sb.toString());
    }

}
