package JUC.Thread_01;

import java.util.Date;

/**
 * @author 阿满
 * @date 2021/04/25
 * @desc Sleep Yield Join
 * Sleep 表示当前线程睡眠一段时间，暂停当前线程，把cpu片段让出给其他线程。
 * Yield 表示先释放一下CPU，先让出一下，返回就绪状态，进入等待队列再等调度进行调用，不管后面其他线程能不能抢到
 * Join 将其他线程加入进来运行，当前线程先等待，等加进来的线程运行完再运行当前线程
 */
public class T05 {

    static void testSleep() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("测试 Sleep 方法，当前第 " + i + "次输出" + "当前时间" + new Date());
                try {
                    Thread.sleep(1000);//睡眠1000毫秒,也就是1S
                    //TimeUnit.Milliseconds.sleep(500)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 创建2个匿名线程相互调用yield方法，查看争抢CPU的结果
     */
    static void testYield() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("测试 Yield 方法，线程1--- " + i);
                if (i % 10 == 0) Thread.yield();//当可以整除10时调用yield方法，10,20,30...时调用，让出CPU时间片
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("线程2抢到了CPU---" + i);
                if (i % 10 == 0) Thread.yield();
            }
        }).start();
    }


    /**
     * 创建t1,t2 两个线程，让第二个线程Join进来，将会导致第一个线程等到Join进来的线程运行完才开始继续运行
     */
    static void testJoin() {
        Thread t1 = new Thread(() -> {
            System.out.println("T1 开始了");
            for (int i = 0; i < 20; i++) {
                System.out.println("T1-------" + i);
                try {
                    Thread.sleep(500);
                    //TimeUnit.Milliseconds.sleep(500)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("T2 开始了");
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 20; i++) {
                System.out.println("T2-------" + i);
                try {
                    Thread.sleep(500);
                    //TimeUnit.Milliseconds.sleep(500)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t2.start();
        t1.start();
    }

    public static void main(String[] args) {
//        testSleep();
//      testYield();
      testJoin();
    }
}
