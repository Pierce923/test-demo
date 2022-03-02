package cc.fivelong.thread;

/**
 * sleep
 * @author youjinbo
 */
public class T003_Sleep_Join_Yield {

    public static void main(String[] args){
        testSleep3();
    }

    static void testSleep(){

        new Thread(
                ()->{
                    for (int i = 0; i <10 ; i++) {
                        System.out.println("sleep-->" + i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

        ).start();

    }

    /**
     * 打印会占用CPU资源
     */
    static void testSleep2(){
        new Thread(
                ()->{
                    for (int i = 0; i < 10000000 ; i++) {
                        System.out.println("占用资源sleep2--> " + i);
                    }
                }

        ).start();
    }

    static void testSleep3(){
        new Thread(
                ()->{
                    for (int i = 0; i < 100 ; i++) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("sleep3");
                }

        ).start();
    }

}
