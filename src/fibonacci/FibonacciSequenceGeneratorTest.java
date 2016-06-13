package fibonacci;

import java.util.List;

import org.junit.Test;

public class FibonacciSequenceGeneratorTest {
	
	@Test
	public void shouldGenerateSequence() {
		FibonacciSequenceGenerator sequenceGenerator=new FibonacciSequenceGenerator();
		List<Integer> sequence = sequenceGenerator.generate(9);
		System.out.println(sequence);
	}
}
