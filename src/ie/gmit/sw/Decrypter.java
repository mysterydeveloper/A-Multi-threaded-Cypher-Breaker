package ie.gmit.sw;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Decrypter implements Runnable {
	private BlockingQueue<Resultable> queue;
	private String cypherText;
	public BlockingQueue<Resultable> getQueue() {
		return queue;
	}

	public void setQueue(BlockingQueue<Resultable> queue) {
		this.queue = queue;
	}

	private int key;
	
	public Decrypter(BlockingQueue<Resultable> queue, String cypherText, int key) {
		super();
		this.queue = queue;
		this.cypherText = cypherText;
		this.key= key;
	}
	public Decrypter() {
		super();
	
	}

	public void run() {
		RailFence rf= new RailFence();
		String plainText = rf.decrypt(cypherText, key);
		//get the score 
		//System.out.println(plainText);
		
		Resultable r= null;// create a result
		try {
			queue.put(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
