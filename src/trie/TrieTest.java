package trie;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrieTest {

	private Trie trie;

	@Before
	public void init() {
		trie = new Trie();
		trie.insert("apple");
		trie.insert("app");
		trie.insert("ape");
		trie.insert("ball");
		trie.insert("cat");
		trie.insert("balloon");
		trie.insert("catter");
	}

	@Test
	public void shouldSearch(){
		Assert.assertTrue(trie.search("app"));
	}
	
	@Test
	public void shouldAutocomplete(){
		Assert.assertEquals(null,trie.autoComplete("z"));
		String[] expected={"ape","app","apple"};
		Assert.assertArrayEquals(expected,trie.autoComplete("ap").toArray());
	}
	
	@Test
	public void testTravellerGoBack(){
		Traveller traveller = trie.getTraveller();
		traveller.goTo('a');
		traveller.goTo('p');
		traveller.goTo('e');
		Node prev=traveller.getPrevious();
		assertNotNull(prev);
	}
}
