/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	/// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code

		str1 = preProcess(preProcessPlus(str1));
		str2 = preProcess(preProcessPlus(str2));

		if (str1.length() != str2.length()) {
			return false;
		}

		int i = 0;
		int j = 0;
		boolean index1 = true;
		boolean index2 = false;
		
		while (i < str1.length() && index1 == true) {
			j=0;
			index2 = false;
			while (j < str2.length() && index2 != true) {
				if (str1.charAt(i) == str2.charAt(j)) {
					index2 = true;
				}
				j++;
			}
			if (index2 == false) {
				index1 = false;
			} else {
				i++;
			}
		}
		if (index1 == true) {
			return true;
		}
		else{
			return false;
		}
	}

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code

		String newstr = "";
		char temp;
		for (int i = 0; i < str.length(); i++) {
			if (((int) str.charAt(i)) < 97 || ((int) str.charAt(i)) > 122) {
				if ((int) str.charAt(i) > 64 && (int) str.charAt(i) < 96) {
					temp = (char) ((int) str.charAt(i) + 32);
					newstr = newstr + temp;
				}
				if ((int) str.charAt(i) == 32) {
					newstr = newstr + str.charAt(i);
				}
			}

			else {
				newstr = newstr + str.charAt(i);
			}
		}
		return newstr;
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		String newstr = "";
		double radnom = Math.random() * str.length();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt((int) radnom) != ' ') {
				newstr += str.charAt((int) radnom);
				str = str.replace(str.charAt((int) radnom), ' ');
			} else {
				while (str.charAt((int) radnom) == ' ') {
					radnom = Math.random() * str.length();
				}
				newstr += str.charAt((int) radnom);
			}
			radnom = Math.random() * str.length();
		}

		return newstr;
	}

	public static String preProcessPlus(String str) {
		// Replace the following statement with your code

		String newstr = "";
		for (int i = 0; i < str.length(); i++) {
			if (((int)str.charAt(i)) != 32) {
				newstr  += str.charAt(i);
			}
		}

		return newstr;
	}

}
