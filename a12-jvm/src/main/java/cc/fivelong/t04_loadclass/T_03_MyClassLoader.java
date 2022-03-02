package cc.fivelong.t04_loadclass;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 从指定位置获取到class文件
 */
public class T_03_MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        T_03_MyClassLoader l = new T_03_MyClassLoader();
        Class<?> clazz = l.loadClass("cc.fivelong.t04_loadclass.HiClassLoader");
        System.out.println("class-->"+clazz.getName());
        System.out.println("ClassLoader-->"+clazz.getClassLoader());
        HiClassLoader h = (HiClassLoader) clazz.newInstance();
        h.m();

    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        String path = name.replaceAll(".", "/").concat(".class");
        File file = new File(path);
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = fis.read()) != 0 ){
                bos.write(b);
            }
            bos.close();
            fis.close();
            byte[] bytes = bos.toByteArray();
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

}
