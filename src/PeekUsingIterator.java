import java.util.Iterator;
import java.util.List;

public class PeekUsingIterator implements Iterator<Integer> {
	private List<Integer> list;
	private int nextIndex=0;
	public PeekUsingIterator(List<Integer> list) {
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		return nextIndex<list.size();
	}

	@Override
	public Integer next() {
		nextIndex++;
		return list.get(nextIndex-1);
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}
}
