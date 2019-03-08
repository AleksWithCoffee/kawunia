import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Anagrams {

	public List<String> loadList() throws Exception {
		List<String> listOfWords = new ArrayList<String>();
		Set<String> setOfWords = new HashSet<String>();

		BufferedReader bufferedReader = new BufferedReader(new FileReader("anagrams2.txt"));
		try {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (!line.equals("")) {
					setOfWords.add(line);
				}
			}
			bufferedReader.close();
			listOfWords.addAll(setOfWords);
		} catch (Exception e) {
			System.out.println("There is no access to that file\n");
		}

		return listOfWords;
	}

	public List<String> findAnagrams(List<String> listOfWords) {
		Date startTime = new Date();
		String s = "Finding anagrams: \n";
		long totalComp = 0;
		List<String> list = new ArrayList<>();

		for (int i = 0; i < listOfWords.size(); i++) {
			for (int j = i + 1; j < listOfWords.size(); j++) {
				String str1 = listOfWords.get(i);
				String str2 = listOfWords.get(j);
				totalComp++;
				if (compareWords(str1, str2)) {
					if (i % 10 == 0) {
						System.out.print(".");
					}
					list.add(str1 + " = " + str2);
				}
			}
		}
		System.out.println(String.format("\nThe number of conducted comparisons: %d\n", totalComp));
		Date endTime = new Date();
		long time = (endTime.getTime() - startTime.getTime()) / 1000;
		System.out.println(String.format("The process lasts: %d seconds\n", time));
		return list;
	}

	public boolean compareWords(String str1, String str2) {
		str1.toLowerCase();
		str2.toLowerCase();

		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();

		Arrays.sort(char1);
		Arrays.sort(char2);

		String sorted1 = new String(char1);
		String sorted2 = new String(char2);

		return sorted1.equals(sorted2);
	}
}