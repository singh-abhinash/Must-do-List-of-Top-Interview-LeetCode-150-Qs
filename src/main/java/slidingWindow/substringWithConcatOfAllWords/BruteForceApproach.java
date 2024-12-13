package slidingWindow.substringWithConcatOfAllWords;

import java.util.ArrayList;
import java.util.List;

public class BruteForceApproach {
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return result;
        }

        List<String> wordsPermutation = new ArrayList<>();
        boolean[] seen = new boolean[words.length];

        generatePermutations(words, wordsPermutation, "", seen);

        int totalLength = words.length * words[0].length();

        for (int i = 0; i < s.length() - totalLength + 1; i++) {
            String sub = s.substring(i, i + totalLength);
            if (wordsPermutation.contains(sub)) {
                result.add(i);
            }
        }
        return result;
    }

    private void generatePermutations(String[] words, List<String> wordsPermutation, String current, boolean[] seen) {
        if (current.length() == words.length * words[0].length()) {
            wordsPermutation.add(current);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!seen[i]) {
                seen[i] = true;
                generatePermutations(words, wordsPermutation, current + words[i], seen);
                seen[i] = false;
            }
        }
    }
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Brute Force Approach
//Generate all permutations of the words in the words list.
//Concatenate each permutation into a single string.
//Search for this concatenated string in the string s using the indexOf() method or by sliding a window over s.
//If found, store the starting index in the result list.

/**
Time Complexity:
	1. Generating Permutations:
		○ There are n! permutations for n words.
		○ Generating all permutations takes O(n! * n) time.
	2. Substring Check:
		○ For each index i in s, extract a substring of size totalLen, which takes O(num * wordLen) time.
		○ We check if the substring exists in the list of permutations, which takes O(n!).
Total Time Complexity: O(n!*n+(s−totalLen)*n!*totalLen)

Space Complexity:
	1. Space required for the list of permutations is O(n!).
	2. Space required for the result list is O(k), where k is the number of starting indices.
	3. Space required for used array is O(n).
Total Space Complexity: O(n!+k+n)

*/
