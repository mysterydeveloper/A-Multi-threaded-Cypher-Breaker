package ie.gmit.sw;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	protected BlockingQueue<Resultable> queue= new ArrayBlockingQueue<Resultable>(1000);
	private volatile double highScore=-1000;
	private Resultable resultfinal ;

    public Resultable getResultfinal() {
		return resultfinal;
	}


	public Consumer(BlockingQueue<Resultable> queue) {
        this.queue = queue;
    }

    public void run() {
    	while(!queue.isEmpty()){
			try {
				Resultable r= queue.take();
				double score=r.getScore();
				if(score>highScore){
					highScore=score;
					resultfinal=r;
					
				}
				//System.out.println(r.getScore());
				//System.out.println(r.getPlainText());
				//if(r instanceof PoisinResult){
				//	return;
				//}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    	
    	
    }


}