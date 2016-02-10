import java.util.LinkedList;
import java.util.List;

/**
 * Created by Gotra on 09.02.2016.
 */
public class MBlockingQueue {

    private List innerQueue = new LinkedList();
    private int queueSize;
    private int defaultSize = 16;

    public MBlockingQueue(int queueSize){
        if (queueSize <= 0) {
            this.queueSize = defaultSize;
        }
        else {
            this.queueSize = queueSize;
        }
    }

    public MBlockingQueue(){
        this.queueSize = defaultSize;
    }

    public synchronized void put(Object item) throws InterruptedException  {
        System.out.println("MBlockingQueue try to put: " + item );
        while (this.innerQueue.size() == this.queueSize) {
            System.out.println("MBlockingQueue queue is full, waiting until space is free");
            wait();
        }
        if (this.innerQueue.size() == 0) {
            System.out.println("MBlockingQueue queue is empty, notify");
            notifyAll();
        }
        this.innerQueue.add(item);
        System.out.println("MBlockingQueue put: " + item );
    }


    public synchronized Object take() throws InterruptedException{
        System.out.println("MBlockingQueue try to take");
        while (this.innerQueue.size() == 0){
            System.out.println("MBlockingQueue queue is empty, waiting until smth is put");
            wait();
        }
        if (this.innerQueue.size() == this.queueSize){
            System.out.println("MBlockingQueue queue is full, notify");
            notifyAll();
        }

        Object item = this.innerQueue.remove(0);
        System.out.println("MBlockingQueue take: " + item );
        return item;
    }

}
