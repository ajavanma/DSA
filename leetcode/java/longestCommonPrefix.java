// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".
package leetcode.java;

class longestCommonPrefix {
    public String solution(String[] strs) {
        if (strs.length == 0)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // shorten the prefix by one character from the end
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}
