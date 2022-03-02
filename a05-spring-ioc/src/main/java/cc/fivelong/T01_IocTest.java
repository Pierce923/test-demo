package cc.fivelong;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T01_IocTest {

    public static void main(String[] args) {
        // 原有创建对象，使用服务方式
        /*MyService myService = new MyService();
        myService.showTest();*/
        // IOC注入
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyService userService = (MyService) context.getBean("userService");
        userService.showTest();
    }

}
