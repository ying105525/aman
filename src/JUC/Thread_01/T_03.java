package JUC.Thread_01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 阿满
 * @date 2021/04/25
 * @desc 通过线程池创建线程
 */
public class T_03 {
    public void createThread(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(()->{
            System.out.println("T03---通过线程池创建线程" + "Hello T_03! ");
        });
        executorService.shutdown();
    }
}
