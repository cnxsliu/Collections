package cnxsliu.collections;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/16 23:58
 * @strategy
 */
public class DeadLock {

    public static void main(String[] args) {
        final Object a = new Object();
        final Object b = new Object();

        new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (a) {
                        System.out.println("T1 got the lock of a");
                        Thread.sleep(1000);
                        System.out.println("T1 was trying to get the lock of b");
                        synchronized (b) {
                            System.out.println("T1 one win");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (b) {
                        System.out.println("T2 two got the lock of b");
                        Thread.sleep(1000);
                        System.out.println("T2 was trying to get the lock of a");
                        synchronized (a) {
                            System.out.println("T2 win");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}