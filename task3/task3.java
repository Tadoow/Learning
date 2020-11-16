package module3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class task3 {
	public static void main(String[] args) throws IOException {
		File folder = new File(args[0]);
		float[] values = new float[16];
		Arrays.fill(values, 0);
		for (File f : folder.listFiles()) {
			BufferedReader br = new BufferedReader(new FileReader(args[0] + f.getName()));
			String line = br.readLine();
			for (int i = 0; i < values.length; i++) {
				values[i] = values[i] + Float.parseFloat(line);
				line = br.readLine();
			}
			br.close();
		}
		int max = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] > values[max])
				max = i;
		}
		System.out.println(max + 1);
	}
}