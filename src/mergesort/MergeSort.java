package mergesort;

import java.util.Arrays;

public class MergeSort {

	private int[] inputArray;

	public int[] ascending(int[] array) {
		inputArray = array;
		sortAscending(array, 0, inputArray.length - 1);
		return inputArray;
	}

	private void sortAscending(int[] array, int start, int end) {
		if (start == end) {
			return;
		}
		int m = (int) Math.floor((start + end) / 2);
		sortAscending(array, start, m);
		sortAscending(array, m + 1, end);
		merge(start, m, end);
	}

	private void merge(int start, int m, int end) {
		int[] left = Arrays.copyOfRange(inputArray, start, m + 1);
		int[] right = Arrays.copyOfRange(inputArray, m + 1, end + 1);

		int index = start;
		int leftIndex = 0;
		int rightIndex = 0;
		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] < right[rightIndex]) {
				inputArray[index] = left[leftIndex];
				index++;
				leftIndex++;
			} else if (right[rightIndex] < left[leftIndex]) {
				inputArray[index] = right[rightIndex];
				index++;
				rightIndex++;
			} else {
				inputArray[index] = left[leftIndex];
				index++;
				leftIndex++;
				inputArray[index] = right[rightIndex];
				index++;
				rightIndex++;
			}
		}
		if (leftIndex < left.length) {
			for (int i = leftIndex; i < left.length; i++) {
				inputArray[index] = left[i];
				index++;
			}
		} else {
			for (int i = rightIndex; i < right.length; i++) {
				inputArray[index] = right[i];
				index++;
			}
		}
	}

}
