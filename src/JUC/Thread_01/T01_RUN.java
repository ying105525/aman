package JUC.Thread_01;

/**
 * @author 阿喵
 * @date 2021/04/25
 * @desc 第一部分的运行程序
 */
public class T01_RUN {
    public static void main(String[] args) {
        Thread t01 = new T_01();
        Thread t02 = new Thread(new T_02());
        T_03 t_03 = new T_03();

        t01.start();
        t02.start();
        t_03.createThread();

    }
}
