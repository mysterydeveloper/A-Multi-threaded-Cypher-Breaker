package ie.gmit.sw;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Decrypter implements Runnable {
	private BlockingQueue<Resultable> queue= new ArrayBlockingQueue<Resultable>(1000);
	private String cypherText;
	private int key;
	
	public Decrypter( String cypherText, int key) {
		super();
		this.cypherText = cypherText;
		this.key= key;
	}

	public void run() {
		RailFence rf= new RailFence();
		String plainText = rf.decrypt(cypherText, key);
		//get the score 
		System.out.println(plainText);
		
		Resultable r= null;// create a result
		try {
			queue.put(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
