import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class ElementsAddToGivenSum {

	@Test
	public void shouldFindElementsThatAddToGivenSum() {
		int[] input = { 1, 4, 3, 2,3,2, 1 - 3, 2, -8, 9, 2 ,-4,5,0};
		List<Integer[]> result = findElementsWithSum(input, 5);
		for(Integer[] i:result){
			System.out.println(i[0]+" "+i[1]);
		}
	}

	private List<Integer[]> findElementsWithSum(int[] input, int sum) {
		int start = 0;
		int end = input.length - 1;
		List<Integer[]> result = new ArrayList<>();
		Map<Integer,Integer> resultMap=new HashMap<>();
		Arrays.sort(input);
		while (start < end) {
			int actualSum = input[start] + input[end];
			if (actualSum == sum) {
				Integer[] a = { Integer.valueOf(input[start]), Integer.valueOf(input[end]) };
				result.add(a);
				resultMap.put(a[0],a[1]);
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
		for(Entry<Integer, Integer> a:resultMap.entrySet()){
			System.out.println(a.getKey()+" "+a.getValue());
		}
		System.out.println("");
		return result;
	}

}
