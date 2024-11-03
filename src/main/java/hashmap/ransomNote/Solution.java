package hashmap.ransomNote;

// Optimized Approach - O(n) time and O(26) = O(1) space
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countLetters = new int[26];
        
        // Count each letter in the magazine
        for (char ch : magazine.toCharArray()) {
            countLetters[ch - 'a']++;
        }
        
        // Check if ransomNote can be constructed
        for (char ch : ransomNote.toCharArray()) {
            if (--countLetters[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
