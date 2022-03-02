package cc.fivelong.thread.t014_thread_pool;


import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 对1-200000累加
 */
public class T09_ForkJoinPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 对数组元素累加

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("single->" + sum);

        SumTask sumTask = new SumTask(0, arr.length);
        // 创建多线程，执行累加
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(sumTask);
        System.out.println(sumTask.join());


    }

    private static int[] arr = new int[100];

    static {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
    }


    static class SumTask extends RecursiveTask<Integer> {

        private int start;
        private int end;

        public SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            //System.out.println("task start!");
            // 拆分数组为两个
            if ((end - start) < 20) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += arr[i];
                }
                return sum;
            } else {
                // 两个子数组并行
                int middle = start + (end - start) / 2;
                SumTask oneTask = new SumTask(start, middle);
                SumTask twoTask = new SumTask(middle, end);
                oneTask.fork();
                twoTask.fork();
                // 子任务合并返回
                return oneTask.join() + twoTask.join();
            }
        }
    }

}
