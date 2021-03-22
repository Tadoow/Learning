package module2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class task2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line = br.readLine();
		Points[] arraySquare = new Points[4];
		int i = 0;
		while (line != null) {
			String[] s = line.split("\\s");
			arraySquare[i] = new Points(Float.parseFloat(s[0]),Float.parseFloat(s[1]));
			line = br.readLine();
			i++;
		}
		br.close();
		BufferedReader brp = new BufferedReader(new FileReader(args[1]));
		String num = brp.readLine();
		ArrayList<Points> arrayPoints = new ArrayList<Points>();
		while (num != null) {
			String[] s = num.split("\\s");
			arrayPoints.add(new Points(Float.parseFloat(s[0]),Float.parseFloat(s[1])));
			num = brp.readLine();
		}
		brp.close();
		Positions pos = new Positions();
		pos.vertexSearch(arraySquare, arrayPoints);
	}
}