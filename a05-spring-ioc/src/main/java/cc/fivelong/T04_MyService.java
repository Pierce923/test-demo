package cc.fivelong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("useService")
public class T04_MyService {

    @Value("T04 test")
    private String text;

    public void showTest(){
        System.out.println(text);
    }

}
