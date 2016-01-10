package ie.gmit.sw;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	protected BlockingQueue<Resultable> queue= new ArrayBlockingQueue<Resultable>(1000);
	private volatile double highScore=-1000;
	private Resultable resultfinal ;
	private int i;
	private int j=0;;

    public Resultable getResultfinal() {
		return resultfinal;
	}


	public Consumer(BlockingQueue<Resultable> queue,int i) {
        this.queue = queue;
        this.i=i;
    }

    public void run() {
    	while(j<i){
			try {
				Resultable r= queue.take();
				double score=r.getScore();
				if(score>highScore){
					highScore=score;
					resultfinal=r;
					
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			j++;
		}
    	
    	
    }


}