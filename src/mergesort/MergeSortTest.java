package mergesort;

import org.junit.Assert;
import org.junit.Test;


public class MergeSortTest {
	MergeSort sort = new MergeSort();
	private int[] array={2,1,3,3,2,1,6,4,5,7,6,5,8,9};
	private int[] sortedExpected={1,1,2,2,3,3,4,5,5,6,6,7,8,9};

	@Test
	public void shouldSortAscending() {
		int[] sorted=sort.ascending(array);
		Assert.assertArrayEquals(sortedExpected,sorted);
	}
}
