import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class task1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		ArrayList<Integer> values = new ArrayList<Integer>();
		String line = br.readLine();
		while (line != null) {
			values.add(Integer.parseInt(line));
			line = br.readLine();
		}
		Methods t = new Methods();
		System.out.printf("%.2f\n", t.percentile(values));
		System.out.printf("%.2f\n", t.median(values));
		System.out.printf("%.2f\n", t.maxValue(values));
		System.out.printf("%.2f\n", t.minValue(values));
		System.out.printf("%.2f\n", t.midValue(values));
		br.close();
	}
}