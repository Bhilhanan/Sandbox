import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {
	@Test
	public void checkPalindromeEmptyString() {
		Assert.assertTrue(Palindrome.isPalindrome(""));
	}
	@Test
	public void checkPalindromeFalse() {
		Assert.assertFalse(Palindrome.isPalindrome("ab"));
	}
	@Test
	public void checkPalindromeTrue() {
		Assert.assertTrue(Palindrome.isPalindrome("aa"));
	}
	
	@Test
	public void checkPalindromeEmptyStringRecursive() {
		Assert.assertTrue(Palindrome.isPalindromeUseRecursive(""));
	}
	@Test
	public void checkPalindromeFalseRecursive() {
		Assert.assertFalse(Palindrome.isPalindromeUseRecursive("ab"));
	}
	@Test
	public void checkPalindromeTrueRecursive() {
		Assert.assertTrue(Palindrome.isPalindromeUseRecursive("aa"));
	}
}
