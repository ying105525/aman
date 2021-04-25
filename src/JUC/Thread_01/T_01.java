package JUC.Thread_01;

/**
 * @author 阿满
 * @date 2021/04/25
 * @desc 通过继承Thread类，重写run()方法创建线程
 */
public class T_01 extends Thread {
    @Override
    public void run() {
        System.out.println("T01---通过继承Thread类创建线程：" + "Hello T_01! ");
    }
}
