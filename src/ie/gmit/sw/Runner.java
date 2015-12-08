package ie.gmit.sw;

import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Runner {


	public static void main(String[] args) throws Exception{
		Decrypter d;
		FileParseable p = new FileParser();
		BlockingQueue<Resultable> queue= new ArrayBlockingQueue<Resultable>(1000);
		Map<String, Double> temp = new ConcurrentHashMap<String, Double>();
		Resultable resultfinal ;
		
		
		temp=p.parse("4grams.txt");
		TextScorer tsr= new TextScorer(temp);

		String s = "THEYAREATTACKINGFROMTHENORTH";
		String g=new RailFence().encrypt(s,4);
		
				 
		//System.out.println(">" + s.length());
		//System.out.println(">" + g);
		ThreadEx.threadStarters(g,queue);
        System.out.println("All tasks submitted.");
        
        
        Consumer con= new Consumer(queue);
        Thread c= new Thread(con);
        c.start();
  
        
        System.out.println("All tasks completed.");
        c.join();
        resultfinal=con.getResultfinal();
        System.out.println(resultfinal.getPlainText());
	}


}
