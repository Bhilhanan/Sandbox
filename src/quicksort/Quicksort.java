package quicksort;

public class Quicksort {
	public static int[] a = { 1, 2, 3, 4, 5, 6, 7 };

	public int findNthBiggest(int left, int right, int n) {
		if (left == right) { // if only one element
			return a[left]; // then return that element
		}
		int pivotIndex = right; // choose the pivot. randomize for better
								// results
		pivotIndex = partition(left, right, pivotIndex); // returns the index of
															// the pivot in the
															// sorted list

		if (pivotIndex == n) {
			return a[pivotIndex];
		}
		if (n < pivotIndex) {
			return findNthBiggest(left, pivotIndex - 1, n);
		} else {
			return findNthBiggest(pivotIndex + 1, right, n);
		}
	}

	private int partition(int left, int right, int pivotIndex) {
		while (left < right) {
			while (a[left] <= a[pivotIndex] && left < a.length - 1) {
				left++;
			}
			while (a[right] > a[pivotIndex] && right >= 0) {
				right--;
			}
			swap(left, right);
		}
		swap(right, pivotIndex);
		return right;
	}

	private void swap(int left, int right) {
		int tmp = a[left];
		a[left] = a[right];
		a[right] = tmp;
	}
}
