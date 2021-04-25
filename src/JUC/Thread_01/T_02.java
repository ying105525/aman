package JUC.Thread_01;

/**
 * @author 阿满
 * @date 2021/04/25
 * @desc 通过实现Runnable接口，重写run()方法创建线程
 */
public class T_02 implements Runnable{
    @Override
    public void run() {
        System.out.println("T02---通过实现Runnable接口创建线程：" + "Hello T_02! ");
    }
}
