package ie.gmit.sw;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {


	public static void main(String[] args) throws Exception{
		Scanner scan=new Scanner(System.in);
		int j=0;
		FileParseable p = new FileParser();
		Map<String, Double> temp = new ConcurrentHashMap<String, Double>();
		Resultable resultfinal ;
		int key;
			
		temp=p.parse("4grams.txt");
		TextScorer tsr= new TextScorer(temp);

		String s ;
		System.out.println("---------START------------");      
		
		System.out.println("Enter text:");
		//s += "THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG";
		
		s=scan.next();
		s=s.toUpperCase();
		
		System.out.println("Enter key:");
		key=scan.nextInt();
		String g=new RailFence().encrypt(s,key);
		System.out.print("encrypted text: ");
		System.out.println(g);
		BlockingQueue<Resultable> queue= new ArrayBlockingQueue<Resultable>(g.length());

		ThreadEx.threadStarters(g,queue);
        j=ThreadEx.getK();
        
        Consumer con= new Consumer(queue,j);
        Thread c= new Thread(con);
        c.start();
        c.join();
        resultfinal=con.getResultfinal();
        System.out.println("\n");      
        System.out.println("---------RESULT------------");
        System.out.print("decrypted text\t: "+resultfinal.getPlainText()
        		+"\n" +"Key\t\t: "+ resultfinal.getKey()
        		+"\n" +"Score\t\t:"+ resultfinal.getScore());
        
	}


}
