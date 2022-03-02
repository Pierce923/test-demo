package cc.fivelong;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T02_ControllerTest {

    public static void main(String[] args) {

        /**
         * 使用ApplicationContext工厂的接口，使用该接口获取具体的Bean对象
         * 该接口下有两个具体实现类：
         * ClassPathXmlApplicationContext 加载类路径下的spring配置文件
         * FileSystemXmlApplicationContext 加载本地磁盘下的spring配置文件
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        MyController useController = (MyController) context.getBean("useController");
        useController.test();
    }

}
