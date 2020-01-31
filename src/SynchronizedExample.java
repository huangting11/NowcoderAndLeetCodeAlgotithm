import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Huangting
 * @Time 2020/1/17
 */
public class SynchronizedExample{
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    void func() {
//        lock.lock();
        System.out.println("dobefore");
        condition.signal();
//        lock.unlock();
    }

    void do1() {
        lock.lock();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("doafter");
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        SynchronizedExample synchronizedExample  = new SynchronizedExample();
//        SynchronizedExample synchronizedExample1  = new SynchronizedExample();
        executorService.execute(synchronizedExample::do1);
        executorService.execute(synchronizedExample::func);
    }
}
