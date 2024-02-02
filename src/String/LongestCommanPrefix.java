package String;

public class LongestCommanPrefix {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        // take the first word and last word and matching the characters of both
        StringBuilder sb = new StringBuilder();
        char []first = strs[0].toCharArray();
        char []last = strs[strs.length-1].toCharArray();

        for (int i = 0 ; i < first.length ; i++){
            if (first[i] ==last[i] ){
                sb.append(first[i]);
            }else {
                break;
            }
        }

        return sb.toString();

    }
}
