package cc.fivelong.t04_loadclass;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class T_06_ClassReload{

    public static void main(String[] args) throws ClassNotFoundException {
        MyLoadClass m = new MyLoadClass();
        Class<?> aClass = m.loadClass("cc.fivelong.t04_loadclass.HiClassLoader");
        System.out.println(aClass);
        m = new MyLoadClass();
        Class<?> bClass = m.loadClass("cc.fivelong.t04_loadclass.HiClassLoader");
        System.out.println(bClass);
        System.out.println(aClass == bClass);
    }


    public static class MyLoadClass extends ClassLoader {
        @Override
        public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            String path = name.replaceAll(".", "/").concat(".class");
            File file = new File(path);
            try {
                FileInputStream fis = new FileInputStream(file);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int b = 0;
                while ((b = fis.read()) != 0) {
                    bos.write(b);
                }
                bos.close();
                fis.close();
                byte[] bytes = bos.toByteArray();
                return defineClass(name, bytes, 0, bytes.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.loadClass(name);
        }
    }


}
