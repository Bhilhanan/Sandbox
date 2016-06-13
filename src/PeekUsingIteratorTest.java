import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PeekUsingIteratorTest {
	@Test
	public void shouldPeek(){
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		PeekUsingIterator peek=new PeekUsingIterator(list);
		Assert.assertTrue(peek.hasNext());
		Assert.assertEquals(Integer.valueOf(1), peek.next());
		Assert.assertTrue(peek.hasNext());
		Assert.assertEquals(Integer.valueOf(2), peek.next());
		Assert.assertTrue(peek.hasNext());
		Assert.assertEquals(Integer.valueOf(3), peek.next());
		Assert.assertTrue(peek.hasNext());
		Assert.assertEquals(Integer.valueOf(4), peek.next());
		Assert.assertFalse(peek.hasNext());
	}
}
