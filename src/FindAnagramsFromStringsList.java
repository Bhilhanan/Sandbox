import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

//Find the anagrams from a list of strings 
//
//Input : {"tea", "ate", "eat", "apple", "java", "vaja", "cut", "utc"} 
//Output : {"tea", "ate", "eat","java", "vaja", "cut", "utc"}
//


public class FindAnagramsFromStringsList {

	@Test
	public void shouldFindAnagrams() {
		String[] input = {"tea", "ate", "eat", "apple", "java", "vaja", "cut", "utc"};
		System.out.println(findAnagrams(Arrays.asList(input)));
	}

	private List<String> findAnagrams(List<String> inputList) {
		Map<String,List<String>> anagramMap=new HashMap<>();
		List<String> list=null;
		for(String word:inputList){
			String key = getkey(word);
			if(anagramMap.containsKey(key)){
				list = anagramMap.get(key);
			}else{
				list=new ArrayList<>();
			}
			list.add(word);
			anagramMap.put(key, list);
		}
		List<String> result=new ArrayList<String>();
		for(Entry<String, List<String>> entry:anagramMap.entrySet()){
			if(entry.getValue().size()>1){
				result.addAll(entry.getValue());
			}
		}
		return result;
	}

	private String getkey(String word) {
		int[] alphabet=new int[26];
		char[] charArray = word.toCharArray();
		for(char c:charArray){
			alphabet[c-97]=1;
		}
		StringBuilder sb=new StringBuilder();
		for(int n:alphabet){
			if(n==1){
				sb.append("1");
			}else{
				sb.append("0");
			}
		}
		return sb.toString();
	}
}
