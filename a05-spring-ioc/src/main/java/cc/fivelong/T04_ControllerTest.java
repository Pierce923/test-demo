package cc.fivelong;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * https://www.jianshu.com/p/2dae9702d142
 * @Component组件
 *
 * @Component衍生三个组件：
 * @Controller -- 作用在WEB层
 * @Service -- 作用在业务层
 * @Repository -- 作用在持久层
 *
 * @Value -- 用于注入普通类型
 * @Autowired -- 默认按类型进行自动装配
 */
public class T04_ControllerTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        T04_MyController useController = (T04_MyController) context.getBean("useController");
        useController.test();
    }

}
