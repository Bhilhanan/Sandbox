import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class ElementsAddToGivenSum {

	@Test
	public void shouldFind2ElementsThatAddToGivenSum() {
		int[] input = { 1, 4, 3, 2, 3, 2, 1 - 3, 2, -8, 9, 2, -4, 5, 0 };
		Map<Integer, Integer> result = find2ElementsWithSum(input, 5);
		for (Entry<Integer, Integer> i : result.entrySet()) {
			System.out.println(i.getKey() + " " + i.getValue());
		}
	}

	@Test
	public void shouldFind3ElementsThatAddToGivenSum() {
		int[] input = { 1, 4, 3, 2, 3, 2, 1 - 3, 2, -8, 9, 2, -4, 5, 0 };
		Map<Integer, Integer[]> result = find3ElementsWithSum(input, 5);
		for (Entry<Integer, Integer[]> entry : result.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue()[0]+" "+entry.getValue()[1]);
		}
	}

	private Map<Integer, Integer[]> find3ElementsWithSum(int[] input, int sum) {
		Map<Integer,Integer[]> result=new HashMap<>();
		for(int i=0;i<input.length;i++){
			int tmpSum=sum-input[i];
			Map<Integer, Integer> tmpResult = find2ElementsWithSum(input, tmpSum);
			if(tmpResult.isEmpty()){
				continue;
			}
			for(Entry<Integer, Integer> a:tmpResult.entrySet()){
				Integer[] array={a.getKey(),a.getValue()};
				result.put(input[i], array);
			}
		}
		return result;
	}

	private Map<Integer, Integer> find2ElementsWithSum(int[] input, int sum) {
		int start = 0;
		int end = input.length - 1;
		List<Integer[]> result = new ArrayList<>();
		Map<Integer, Integer> resultMap = new HashMap<>();
		Arrays.sort(input);
		while (start < end) {
			int actualSum = input[start] + input[end];
			if (actualSum == sum) {
				Integer[] a = { Integer.valueOf(input[start]), Integer.valueOf(input[end]) };
				result.add(a);
				resultMap.put(a[0], a[1]);
				start++;
				end--;
				continue;
			}
			if (actualSum < sum) {
				start++;
			} else {
				end--;
			}
		}
//		for (Entry<Integer, Integer> a : resultMap.entrySet()) {
//			System.out.println(a.getKey() + " " + a.getValue());
//		}
//		System.out.println("");
		return resultMap;
	}

}
