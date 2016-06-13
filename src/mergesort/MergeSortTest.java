package mergesort;

import org.junit.Test;

public class MergeSortTest {
	MergeSort sort = new MergeSort();
	private int[] array={2,1,3,3,2,1,6,4,5,7,6,5,8,9};

	@Test
	public void shouldSortAscending() {
		int[] sorted=sort.ascending(array);
		for(int i=0;i<sorted.length;i++){
			System.out.print(sorted[i]+" ");
		}
	}
}
