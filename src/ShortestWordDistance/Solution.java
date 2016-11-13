package ShortestWordDistance;
public class Solution {
    // review logic again
    public int shortestDistance(String[] words, String word1, String word2) {
        int min = words.length;
        int idx1 = -1;
        int idx2 = -1;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                idx1 = i;
            } else if(words[i].equals(word2)) {
                idx2 = i;
            } else {
                continue; // skip
            }
            if(idx1 >= 0 && idx2 >= 0) { // if idx1,idx2 already set, >=0 instead of >0, mistake made
                min = Math.min(min, Math.abs(idx1 - idx2));
            }
        }
        return min;
    }
}
