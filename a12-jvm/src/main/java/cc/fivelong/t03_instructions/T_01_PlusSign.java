package cc.fivelong.t03_instructions;

/**
 * i++与++i的区别， 通过指令解析
 * i++: 在i赋值以后，再+1
 * ++i: 在i赋值之前，先+1
 */
public class T_01_PlusSign {
    public static void main(String[] args) {
        int i = 8;
        //i = i++;
        i = ++i;
        System.out.println(i);
    }
}

