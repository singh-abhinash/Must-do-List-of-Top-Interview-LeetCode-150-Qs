package slidingWindow.substringWithConcatOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlidingWindowApproach {
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return result;
        }

        Map<String, Integer> countWords = new HashMap<>();
        for (String word : words) {
            countWords.put(word, countWords.getOrDefault(word, 0) + 1);
        }
        
        int numOfWords = words.length;
        int wordLength = words[0].length();
        int totalLength = numOfWords * wordLength;

        for (int i = 0; i < s.length() - totalLength + 1; i++) {
            String sub = s.substring(i, i + totalLength);
            if (isConcat(sub, countWords, wordLength)) {
                result.add(i);
            }
        }
        return result;
    }
    
    private boolean isConcat(String sub, Map<String, Integer> counts, int wordLength) {
        Map<String, Integer> seen = new HashMap<>();
        for (int i = 0; i < sub.length(); i += wordLength) {
            String sWord = sub.substring(i, i + wordLength);
            seen.put(sWord, seen.getOrDefault(sWord, 0) + 1);
        }
        return seen.equals(counts);
    }
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
Optimal Approach:

Count Word Frequencies:
Store the frequency of each word from words in a hashmap counts.

Sliding Window:
Slide a window of size totalLength = numOfWords * wordLength from 0 to s.length() - totalLength + 1.

Check Valid Substring:
Split the window into chunks of size wordLength and track their frequencies in a hashmap seen.
If seen matches counts, add the starting index to the result list.

Return Result:
Return all indices where a concatenated substring is found.

Time Complexity:
	• Outer Loop: O(n) where n is the length of s.
	• Inner Loop: O(k) where k is the number of words.
	• Total: O(n⋅k).
Space Complexity:
	• Space for hashmaps (counts and seen): O(k).
	• Space for the result list: O(n).

 */
