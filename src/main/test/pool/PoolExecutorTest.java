package pool;
import javafx.concurrent.Worker;
import org.junit.Test;
import java.util.HashSet;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class PoolExecutorTest {

//    private final BlockingDeque<Runnable> workQueue; //任务缓存队列,用来存放等待执行的任务
    private final ReentrantLock mainLock = new ReentrantLock(); //线程池主要状态锁,对线程池的状态改变都需要这个锁
    private final HashSet<Worker> workers = new HashSet<Worker>(); //用来存放工作集
    private volatile long keepAAliveTime; //线程存活时间
    private volatile boolean allowCoreThreadTimeOut; //是否允许为核心线程设置存活时间
    private volatile int corePoolSize; //核心线程大小
    private volatile int maxPoolSize; //最大线程数
    private volatile int poolSize; //当前的线程数
    private RejectedExecutionHandler handler; //任务拒绝策略
    private volatile ThreadFactory threadFactory; //线程工厂
    private int largestPoolSize; //出现过的最大线程数
    private Long completedTaskCount; //记录已经完成的线程任务数

    @Test
    public void test1(){

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,15,200,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(5));

        for (int i=0;i<15;i++){

            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+ executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

    class MyTask implements Runnable{

        private int taskNum;
        MyTask(int taskNum){
            this.taskNum =taskNum;
        }
        @Override
        public void run(){

            System.err.println("正在执行task"+taskNum);
            try {
                Thread.sleep(4000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.err.println("taskNum"+taskNum+"执行完毕");
        }
    }
}
