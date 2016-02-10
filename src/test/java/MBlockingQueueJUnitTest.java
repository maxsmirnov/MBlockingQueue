import junit.framework.TestCase;

import java.util.Random;

/**
 * Created by Gotra on 09.02.2016.
 */
public class MBlockingQueueJUnitTest extends TestCase {

    private final MBlockingQueue blockingQueue = new MBlockingQueue(20);

    protected void setUp() throws Exception {
        blockingQueue.put(new byte[0]);
        blockingQueue.put("someString");
        blockingQueue.put(new byte[] { 0, -1, -14, 17, -128 });

    }

    protected void tearDown() throws Exception {
///        blockingQueue.clear();
    }

    public void testToBlockingQueue() {
        MBlockingQueue queue = new MBlockingQueue(5);
        new Thread(new ProducerThread(queue)).start();
        try {
            Thread.currentThread().sleep(1000);
        }
        catch (InterruptedException exc) {

        }
        new Thread(new ConsumerThread(queue)).start();
    }

}
