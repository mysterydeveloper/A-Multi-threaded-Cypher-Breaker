package ie.gmit.sw;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	protected BlockingQueue<Resultable> queue= new ArrayBlockingQueue<Resultable>(1000);

    public Consumer(BlockingQueue<Resultable> queue) {
        this.queue = queue;
    }

    public void run() {
    	while(queue.isEmpty()){
			try {
				Resultable r= queue.take();
				System.out.println("1");
				//if(r instanceof PoisinResult){
				//	return;
				//}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//do something...........
		}
    }


}