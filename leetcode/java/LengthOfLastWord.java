package leetcode.java;

// Given a string s consisting of words and spaces, return the length of the last word in the string.
// * A word is a maximal substring consisting of non-space characters only.


class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        
        String[] words = s.trim().split("\\s+");        // Remove leading and trailing spaces, then split the string by spaces, 
                                                              // split("\\s+") : a regular expression to split the string around sequences of one or more whitespace characters
        return words[words.length - 1].length();              // Get the last word from the array and return its length
    }
}
