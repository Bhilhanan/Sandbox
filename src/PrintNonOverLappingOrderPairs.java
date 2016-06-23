import org.junit.Test;

//# take an array and print non over lapping in order pairs. example:
//
//
//# [1,2,3,4] => input
//
//# output below is in order combination
//
//# (1234)
//# (1)(234)
//# (1)(23)(4)
//# (1)(2)(34)
//# (12)(34)
//# (12)(3)(4)
//# (123)(4)
//# (1)(2)(3)(4)

public class PrintNonOverLappingOrderPairs {

	@Test
	public void printNonOverlappingOrderPairs() {
		String input = "1234";
		printNonOverLappingOrderPairs(input, "");
	}

	private void printNonOverLappingOrderPairs(String input, String prefix) {
		System.out.println(prefix + "(" + input + ")");
		for (int i = 1; i < input.length(); i++) {
			String newPrefix = prefix + "(" + input.substring(0, i) + ")";
			printNonOverLappingOrderPairs(input.substring(i), newPrefix);
		}
	}
}
