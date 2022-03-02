package cc.fivelong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("useController")
public class T04_MyController {

    @Autowired
    private T04_MyService myService;

    public void test(){
        myService.showTest();
    }

}
