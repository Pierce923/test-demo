package cc.fivelong.t04_loadclass;

/**
 * 加载类: 通过AppClassLoader加载T_02_LoadClass类
 */
public class T_02_LoadClass {

    public static void main(String[] args){
        try {
            System.out.println(T_02_LoadClass.class.getClassLoader());
            Class<?> clazz = T_02_LoadClass.class.getClassLoader().loadClass("cc.fivelong.t04_loadclass.T_01_ClassLoadLevel");
            System.out.println(clazz.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
