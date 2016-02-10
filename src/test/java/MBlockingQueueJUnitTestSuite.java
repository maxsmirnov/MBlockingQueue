import junit.framework.TestSuite;

/**
 * Created by Gotra on 09.02.2016.
 */
public class MBlockingQueueJUnitTestSuite extends TestSuite {
    public MBlockingQueueJUnitTestSuite() {
        addTestSuite(MBlockingQueueJUnitTest.class);
        addTestSuite(ConsumerThreadJunitTest.class);
        addTestSuite(ProducerThreadJUnitTest.class);
    }
}
