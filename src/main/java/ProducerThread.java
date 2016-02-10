import java.util.Random;

/**
 * Created by Gotra on 09.02.2016.
 */
public class ProducerThread implements Runnable {
    private final MBlockingQueue queue;

    public ProducerThread(MBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("ProducerThread run");
        while (true) {
            try {
                queue.put(produce());
                Thread.currentThread().sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Integer produce() {
        Integer i = new Random().nextInt(100);
        System.out.println("ProducerThread: " + i);
        return i;
    }
}
