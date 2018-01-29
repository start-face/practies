package pool;
import com.tuhao.base.IRedisAdapterImpl;
import com.tuhao.base.ValueClass;
import com.tuhao.pool.WorkQueue;
import org.asyou.redis.dao.IRedisAdapter;
import org.asyou.redis.lock.ILock;
import org.asyou.redis.lock.RedisLock;
import org.asyou.redis.time.LocalTimeClient;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class PoolTest {

    @Test
    public void test5(){

        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");

        System.err.println(map.get("4"));
    }

    @Test
    public void test4() throws Exception{

        IRedisAdapter adapter = new IRedisAdapterImpl();
        ILock lock = new RedisLock(adapter, "lock:loan:1", 5 * 1000, new LocalTimeClient());
        if (lock.tryLock(3 * 1000, TimeUnit.MILLISECONDS)) {
            //TODO 成功获得锁，有效时间为 5 * 1000

        }
    }

    @Test
    public void test3() throws Exception {

        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<Integer> submit = pool.submit(new IntegerCallable());

        Integer integer = submit.get();
        System.err.println("返回值为:"+integer);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Boolean> fu = executorService.submit(new BooleanCallable());
        Boolean aBoolean = fu.get();
        System.out.println("返回值为:"+aBoolean);

        pool.shutdown();
        executorService.shutdown();
    }

    private static final class IntegerCallable implements Callable<Integer>{

        //返回类型由泛型决定
        @Override
        public Integer call() throws Exception {
            return 2;
        }
    }

    private static final class BooleanCallable implements Callable<Boolean>{

        @Override
        public Boolean call(){

            return true;
        }
    }

    @Test
    public void test1() throws Exception{

        WorkQueue workQueue = new WorkQueue(10);
        ValueClass valueClass = new ValueClass();
        ValueClass valueClass1 = new ValueClass();

        for (int i=0;i<100;i++){
            workQueue.execute(valueClass);
            if (i%10==0){
                Thread.sleep(2000);
                for (int j=0;j<10;j++){
                    workQueue.execute(valueClass1);
                    System.err.println("执行了第二个类");
                }
            }
            System.err.println("执行了第一个类");
        }
    }

    @Test
    public void test2() throws Exception{

        System.err.println("------------------------FixedThreadPool----------------------------");
        ExecutorService executorService = getFixedThreadPool(2);
        executeThread(executorService);
        Thread.sleep(3000);

        System.err.println("---------------------CashedThreadPool------------------------");
        ExecutorService executorService1 = getCashedThreadPools();
        executeThread(executorService1);
        Thread.sleep(3000);

        System.err.println("----------------------SingleThreadPool-----------------------");
        ExecutorService executorService2 = getSingleThreadPool();
        executeThread(executorService2);
    }

    private static void executeThread(ExecutorService pool){

        Thread thread =new myThread();
        Thread thread1 =new myThread();
        Thread thread2 =new myThread();
        Thread thread3 =new myThread();
        Thread thread4 =new myThread();
        Thread thread5 =new myThread();
        Thread thread6 =new myThread();
        Thread thread7 =new myThread();
        Thread thread8 =new myThread();

        pool.execute(thread);
        pool.execute(thread1);
        pool.execute(thread2);
        pool.execute(thread3);
        pool.execute(thread4);
        pool.execute(thread5);
        pool.execute(thread6);
        pool.execute(thread7);
        pool.execute(thread8);
        pool.shutdown();
    }

    private static final class myThread extends Thread{

        @Override
        public void run(){
            super.run();
            System.out.println(Thread.currentThread().getName() + ": is running!");
        }
    }

    //只存在一个线程的线程池
    private static ExecutorService getSingleThreadPool(){
        return Executors.newSingleThreadExecutor();
    }

    //存在多个线程的线程池
    private static ExecutorService getCashedThreadPools(){
        return Executors.newCachedThreadPool();
    }
    //存在指定数量的线程池
    private static ExecutorService getFixedThreadPool(int sizePool){
        return Executors.newFixedThreadPool(sizePool);
    }
}
