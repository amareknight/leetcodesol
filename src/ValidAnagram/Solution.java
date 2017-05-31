package ValidAnagram;

import java.util.HashMap;

/* multiple solutions:
 * 1. HashMap, <char,count>
 * 2. There are only 26 characters, use an array to store count of each letter. int[26]
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> charNum = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if( charNum.containsKey(s.charAt(i)) ) {
                charNum.replace(s.charAt(i), charNum.get(s.charAt(i)) + 1);
            } else {
                charNum.put(s.charAt(i), 1);
            }
        }
        for(int i=0; i<t.length(); i++) {
            if( charNum.containsKey(t.charAt(i)) ) {
                charNum.replace(t.charAt(i), charNum.get(t.charAt(i)) - 1);
                if (charNum.get(t.charAt(i)) == 0) {
                    charNum.remove(t.charAt(i));
                }
            } else {
                return false;
            }
        }
        if(!charNum.isEmpty()) return false;
        return true;
    }
}