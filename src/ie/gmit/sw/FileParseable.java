package ie.gmit.sw;

import java.io.IOException;
import java.util.Map;

public interface FileParseable {

	public abstract Map<String, Double> parse(String file) throws IOException;

}