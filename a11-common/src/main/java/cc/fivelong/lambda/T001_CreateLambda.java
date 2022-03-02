package cc.fivelong.lambda;

/**
 * (parameters) -> expression
 * 或
 * (parameters) ->{ statements; }
 *
 * ()描述表达式
 * {}描述方法体
 * -> 为 lambda运算符
 */
public class T001_CreateLambda {


    public static void main(String[] args) {
        //
        Runnable t1 = () -> System.out.println("t1");
        new Thread(t1).start();

        // 简化
        new Thread(() -> System.out.println("t2")).start();

        // ()->{}  {}描述方法体
/*        Runnable t3 = () -> {
            new Runnable() {

                @Override
                public void run() {
                    System.out.println("t3");
                }
            };
        };
        new Thread(t3).start();*/

        // 参数返回
    }


}
