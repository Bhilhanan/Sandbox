package fibonacci;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class FibonacciSequenceGeneratorTest {
	
	@Test
	public void shouldGenerateSequence() {
		FibonacciSequenceGenerator sequenceGenerator=new FibonacciSequenceGenerator();
		List<Integer> sequence = sequenceGenerator.generate(9);
		Assert.assertEquals(9, sequence.size());
		Integer[] expectedSequence={1,1,2,3,5,8,13,21,34};
		Assert.assertArrayEquals(expectedSequence, sequence.toArray());
	}
}
