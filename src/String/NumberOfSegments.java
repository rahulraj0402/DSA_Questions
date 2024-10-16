package String;

import java.util.StringTokenizer;

public class NumberOfSegments {
    public static void main(String[] args) {

    }

    public int countSegments(String s) {
        StringTokenizer stringTokenizer = new StringTokenizer(s);
        return stringTokenizer.countTokens();
    }
}
