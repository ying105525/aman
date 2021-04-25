package JUC.Thread_01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 阿喵
 * @date 2021/04/25
 * @desc 第一部分的运行程序
 */
public class T01_RUN {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t01 = new T_01();
        Thread t02 = new Thread(new T_02());
        FutureTask futureTask = new FutureTask(new T_03());
        Thread t03 = new Thread(futureTask);

        T_04 t_04 = new T_04();

        t01.start();
        t02.start();
        t03.start();
        t_04.createThread();

    }
}
