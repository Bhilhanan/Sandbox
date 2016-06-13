package fibonacci;

import java.util.ArrayList;
import java.util.List;


public class FibonacciSequenceGenerator {

	public List<Integer> generate(int numCount) {
		int i=0;
		int j=1;
		List<Integer> sequence=new ArrayList<Integer>();
		sequence.add(j);
		numCount--;
		while(numCount>0){
			int k = i+j;
			sequence.add(k);
			i=j;
			j=k;
			numCount--;
		}
		return sequence;
	}

}
