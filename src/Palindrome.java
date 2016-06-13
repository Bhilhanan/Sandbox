public class Palindrome {

	public static boolean isPalindrome(String word) {
		if(word==null){
			return false;
		}
		char[] wordCharArray = word.toCharArray();
		int end = wordCharArray.length - 1;
		for (int i = 0; i <= end; i++, end--) {
			if (wordCharArray[i] != wordCharArray[end]) {
				return false;
			}
		}
		return true;
	}
	public static boolean isPalindromeUseRecursive(String word) {
		if(word==null){
			return false;
		}
		if(word.isEmpty()){
			return true;
		}
		char[] wordCharArray=word.toCharArray();
		return isPalindrome(wordCharArray,0);
	}

	private static boolean isPalindrome(char[] wordCharArray, int start) {
		int end=wordCharArray.length-1-start;
		if(start==end || start>end){
			return true;
		}
		
		if(wordCharArray[start]==wordCharArray[end]){
			return isPalindrome(wordCharArray, start+1);
		}
		return false;
	}

}
