public class DeadlockCorrigido {
    static final Object LOCK_A = new Object();
    static final Object LOCK_B = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            adquirirNaOrdem(LOCK_A, LOCK_B, "T1");
        });

        Thread t2 = new Thread(() -> {
            adquirirNaOrdem(LOCK_A, LOCK_B, "T2"); 
        });

        t1.start();
        t2.start();
    }

    static void adquirirNaOrdem(Object first, Object second, String name) {
        synchronized (first) {
            System.out.println(name + " adquiriu primeiro");
            dormir(50);
            System.out.println(name + " tentando adquirir segundo");
            synchronized (second) {
                System.out.println(name + " concluiu");
            }
        }
    }

    static void dormir(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
