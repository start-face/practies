package thread;

import com.tuhao.multi.MultiOne;
import com.tuhao.multi.MultiRun;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class ThreadTest {

    @Test
    public void test3() throws Exception {

        System.err.println("线程开始");
        Date date = new Date();

        int taskSize = 5;
        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        //创建个多个有返回值的任务
        List<Future> list = new ArrayList<>();

        for (int i = 0; i < taskSize; i++) {

            Callable callable = new MyCallable(i + "");
            // 执行任务并获取Future对象
            Future future = pool.submit(callable);
            list.add(future);
        }
        //关闭线程池
        pool.shutdown();

        //获取所有并发任务的运行结果
        list.forEach(one -> {

            try {
                System.err.println(">>>" + one.get().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        Date date1 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【" + (date1.getTime() - date.getTime()) + "毫秒】");
    }

    class MyCallable implements Callable<Object> {

        private String taskNum;

        MyCallable(String taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public Object call() throws Exception {

            System.err.println(">>>" + taskNum + "staring");
            Date date = new Date();
            Thread.sleep(1000);
            Date date1 = new Date();
            Long time = date1.getTime() - date.getTime();
            System.err.println(">>>" + taskNum + "");
            return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
        }
    }

    @Test
    public void test2() {

        MultiOne multiOne = new MultiOne();
        Thread thread = new Thread(multiOne);
        Thread thread1 = new Thread(multiOne);

        thread.start();
        thread1.start();
    }

    @Test
    public void test1() {

        MultiRun multiRun = new MultiRun();
        MultiRun multiRun1 = new MultiRun();

        multiRun.start();
        multiRun1.start();
    }
}
