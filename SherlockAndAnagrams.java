import java.util.Scanner;

/*Given a string S, find the number of "unordered anagrammatic pairs" of substrings.

Input Format

First line contains T, the number of testcases. Each testcase consists of string S in one line.

Constraints 
1≤T≤10 
2≤length(S)≤100 
String S contains only the lowercase letters of the English alphabet.

Output Format

For each testcase, print the required answer in one line.

Sample Input

2
abba
abcd
Sample Output

4
0*/
public class SherlockAndAnagrams {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		sc.nextLine();
		for(int i = 0 ; i < cases; i++){
			System.out.println(findAnagramPairs(sc.nextLine()));
		}
		sc.close();
	}

	private static int findAnagramPairs(String nextLine) {
		int pairCounts = 0;
		for(int i = 0; i < nextLine.length(); i++){
			int pairSize = i+1;
			String[] subStrings = getSubstrings(pairSize, nextLine);
			pairCounts += countAnagrams(subStrings);
			
		}
		return pairCounts;
	}

	/**
	 * counts the number of anagram pairs in given array of strings.
	 * @param subStrings
	 * @return count of anagram pairs
	 */
	private static int countAnagrams(String[] subStrings) {
		int count  = 0;
		for(int i = 0; i < subStrings.length ; i++){
			for(int j = i+1 ; j < subStrings.length ; j++){
				if(isAnagram(subStrings[i], subStrings[j])){
					count ++; 	
				}
			}
		}
		return count;
	}


	/**
	 * checks if given string is anagram of another given string.
	 * @param string
	 * @param string2
	 * @return
	 */
	private static boolean isAnagram(String string, String string2) {
		int[] c1 = getCount(string);
		int[] c2 = getCount(string2);
		for(int i = 0; i < 26; i++){
			if(c1[i] != c2[i]){
				return false;
			}
		}
		return true;
	}

	/**
	 * takes size of the substring 'n' and a string s , and returns the arry of all substrings of size n
	 * @param pairSize
	 * @param nextLine
	 * @return
	 */
	private static String[] getSubstrings(int pairSize, String nextLine) {
		String[] substring = new String[nextLine.length()-pairSize + 1];
		for(int i = 0; i < (nextLine.length()-pairSize + 1); i++){
			substring[i] = nextLine.substring(i, i+pairSize);
		}
		return substring;
	}
	
	private static int[] getCount(String string1) {
		int[] countOfLetters = new int[26];
		char[] giveChars = string1.toCharArray();
		for(int i = 0 ; i < giveChars.length ; i++){
			countOfLetters[giveChars[i]-'a']++;
		}
		return countOfLetters;
	}

}
