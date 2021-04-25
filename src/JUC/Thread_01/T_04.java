package JUC.Thread_01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 阿满
 * @date 2021/04/25
 * @desc 通过线程池创建线程
 */
public class T_04 {
    public void createThread(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(()->{
            System.out.println("T04---通过线程池创建线程" + "Hello T_04! ");
        });

        executorService.submit(new T_03());//runnable类型的入参，  <T> Future<T> submit(Callable<T> task);
        executorService.shutdown();
    }
}
