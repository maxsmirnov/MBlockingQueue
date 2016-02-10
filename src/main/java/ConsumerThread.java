/**
 * Created by Gotra on 09.02.2016.
 */
public class ConsumerThread implements Runnable {
    private final MBlockingQueue queue;

    public ConsumerThread (MBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("ConsumerThread start");
        while (true) {
            try {
                consume();
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        try {
            Integer i = (Integer) queue.take();
            System.out.println("ConsumerThread: " + i);
        }
        catch (Exception exc) {

        }
    }
}