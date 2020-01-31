import sun.reflect.generics.repository.ConstructorRepository;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Huangting
 * @Time 2020/1/16
 */
public class Test1 implements Cloneable, AB{
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(1);
        Thread.yield();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
//                    while (!) {
                        // ..
//                    }
                    System.out.println("Thread end");
                }
            });
        }
        executorService.shutdown();

        Test1 t = new Test1();
        try {
            Class a = Class.forName("_25_Clone");
            System.out.println(a.getResource("bbb"));
            _25_Clone clonea = (_25_Clone) a.newInstance();
            System.out.println(clonea.bbb);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
//        t.
        try {
            Test1 t2 = (Test1) t.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public List<? extends Number>  get() {
        return null;
    }

//    @Override
//    public void B(T t) {
//        String.valueOf(t);
////        a = 5;
//    }


    @Override
    public void B(Object o) {

    }
}

