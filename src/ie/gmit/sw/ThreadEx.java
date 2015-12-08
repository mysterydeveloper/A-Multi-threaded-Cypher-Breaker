package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadEx {

	public static void threadStarters(String g,BlockingQueue<Resultable> queue) {
	
		ExecutorService executor = Executors.newFixedThreadPool(g.length()/2);
        
        for(int i=2; i<g.length()/2; i++) {
            executor.submit(new Decrypter(queue,g,i));
        }
        
        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
        }
	}

}
