package JUC.Thread_01;

import java.util.concurrent.Callable;

/**
 * @author 阿满
 * @date 2021/04/25
 * @desc 通过实现Callable接口，重写call()方法创建线程
 */
public class T_03 implements Callable {


    @Override
    public Object call() throws Exception {
        System.out.println("T03---通过实现Callable接口创建线程：" + "Hello T_03! ");
        return null;
    }
}
