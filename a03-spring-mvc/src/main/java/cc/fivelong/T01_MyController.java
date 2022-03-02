package cc.fivelong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class T01_MyController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "hi Controller";
    }

}
