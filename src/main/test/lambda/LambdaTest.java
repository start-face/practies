package lambda;
import org.junit.Test;

public class LambdaTest {

    @Test
    public void test2(){

//        List<Person> list = Person.createSortList();
        
    }

    @Test
    public void test(){

        Runnable runnable1 = new Runnable() {

            @Override
            public void run(){
                System.err.println("run....");
            }
        };

        Runnable r2 = ()->{
            System.out.println("lambda....");
        };

        runnable1.run();
        r2.run();
    }
}
