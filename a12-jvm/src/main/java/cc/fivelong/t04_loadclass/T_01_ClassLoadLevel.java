package cc.fivelong.t04_loadclass;

/**
 * classload层级
 * 1.bootstrap加载器
 * 2.ex
 */
public class T_01_ClassLoadLevel {


    public static void main(String[] args){
        System.out.println(String.class.getClassLoader());
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        System.out.println(T_01_ClassLoadLevel.class.getClassLoader());
    }

}
