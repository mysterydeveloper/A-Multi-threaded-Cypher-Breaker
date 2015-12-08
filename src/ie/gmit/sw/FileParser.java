package ie.gmit.sw;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FileParser implements FileParseable {
	private Map<String, Double> temp = new ConcurrentHashMap<String, Double>();
	
	private String next= null;
	private double num1=0;
	private String string1=" ";
	
	
	public  Map<String, Double> parse(String file) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		while((next=br.readLine())!=null){
				// ADD EACH LINE TO THE PARSE
				String [] stuff = next.split(" ");
				//map.put(stuff[0]),stuff[1]);	
				num1=(double) Long.parseLong(stuff[1]);
				string1=stuff[0];
				temp.put(string1, num1);
		}
		return temp;
		
		
	}
}
