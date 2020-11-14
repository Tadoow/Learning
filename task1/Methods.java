import java.util.*;

public class Methods {
	public float maxValue(ArrayList<Integer> values) {
		int max = values.get(0);
		for (int i = 1; i < values.size(); i++) {
			if (values.get(i) > max)
				max = values.get(i);
		}
		return max;
	}
	
	public float minValue(ArrayList<Integer> values) {
		int min = values.get(0);
		for (int i = 1; i < values.size(); i++) {
			if (values.get(i) < min)
				min = values.get(i);
		}
		return min;
	}
	
	public ArrayList<Integer> sort(ArrayList<Integer> values) {
		for (int k = 0; k < values.size() - 1; k++) {
			int min = k;
			for (int i = k + 1; i < values.size(); i++) {
				if (values.get(i) < values.get(min))
					min = i;
			}
			int temp = values.get(k);
			values.set(k,values.get(min));
			values.set(min, temp);
		}
		return values;
	}
	
	public float median(ArrayList<Integer> values) {
		ArrayList<Integer> sorted = sort(values);
		int size = sorted.size();
		if ((size % 2) == 0)
			return (sorted.get(size/2 - 1) + sorted.get(size/2))/2;
		else
			return sorted.get((size - 1)/2);
	}
	
	public float percentile(ArrayList<Integer> values) {
		ArrayList<Integer> sorted = sort(values);
		float rank = (float) (90*(sorted.size()-1))/100 + 1;
		float per = values.get((int)rank-1) + (rank % 1) * ((values.get((int)rank)) - (values.get((int)rank-1)));
		return per;
	}
	
	public float midValue(ArrayList<Integer> values) {
		int sum = 0;
		for (int i = 1; i < values.size(); i++)
			sum += values.get(i);
		return (float)sum/values.size();
	}
}