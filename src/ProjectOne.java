import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjectOne {

	public static void main(String[] args) throws Exception {

		List<String> list = new ArrayList<String>();
		List<String> listOfAnagrams = new ArrayList<String>();
		Anagrams anagram = new Anagrams();
		list = anagram.loadList();
		if (list.size() == 0) {
			System.out.println("No words have been loaded.\n");
		} else {
			System.out.printf(String.format("%d of unique words have been loaded.\n", list.size()));
			listOfAnagrams = anagram.findAnagrams(list);
			System.out.println(String.format("%d of anagrams have been found.\n", listOfAnagrams.size()));
			for (String s : listOfAnagrams) {
				System.out.println(s);
			}

		}

	}

}