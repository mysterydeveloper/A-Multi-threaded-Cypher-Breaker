package ie.gmit.sw;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Runner {


	public static void main(String[] args) throws Exception{
		Decrypter d= new Decrypter();
		BlockingQueue<Resultable> queue= new ArrayBlockingQueue<Resultable>(1000);
		
		
		String s = "THEYAREATTACKINGFROMTHENORTH";
		String g=new RailFence().encrypt(s,4);
		
				 
		//System.out.println(">" + s);
		//System.out.println(">" + g);
		ExecutorService executor = Executors.newFixedThreadPool(s.length()/2);
        
        for(int i=2; i<g.length()/2; i++) {
            executor.submit(new Decrypter(queue,g,i));
        }
        
        executor.shutdown();
        
        System.out.println("All tasks submitted.");
        Consumer con= new Consumer(queue);
        Thread c= new Thread(con);
        c.start();
  
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
        }
        
        System.out.println("All tasks completed.");

	}


}
