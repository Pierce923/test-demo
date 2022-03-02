package cc.fivelong;

public class MyController {

    private MyService myService;

    public void setMyService(MyService myService){
        this.myService = myService;
    }

    public void test(){
        myService.showTest();
    }

}
