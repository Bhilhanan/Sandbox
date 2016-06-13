package quicksort;

import org.junit.Assert;
import org.junit.Test;


public class QuicksortTest {

	@Test
	public void testNthBiggestNumber(){
		Quicksort s=new Quicksort();
		int n=7;
		int num=s.findNthBiggest(0,s.a.length-1,s.a.length-n);
		Assert.assertEquals(1,num);
	}
}
