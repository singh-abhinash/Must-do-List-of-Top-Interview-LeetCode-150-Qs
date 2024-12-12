package twoPointer.isSubsequence;

public class TwoPointerApproach {
	public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true; // Empty string is always a subsequence
        int i = 0, j = 0;
        
        while (j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                if (i == s.length()) return true; // If we've matched the whole 's', return true
            }
            j++;
        }
        
        return false;
    }
}
