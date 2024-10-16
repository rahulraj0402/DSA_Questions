package String;

import java.util.List;

public class CountItemMatchingRule {
    public static void main(String[] args) {

    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        // we have 3 rule key 1) type 2) color 3) name
        // type -> index 0
        // type -> index 1
        // type -> index 2

        // for iterating to all list inside list and getting the certian index number we have to user
        // list.get(i).get(0) -- > type

        int ans = 0 ;
        
        // for type
        if (ruleKey.equals("type")){
            for (int i = 0 ; i < items.size() ; i++){
                if (items.get(i).get(0).equals(ruleValue)){
                    ans++;
                }
            }
        } else if (ruleKey.equals("color")) {
            for (int i = 0 ; i < items.size() ; i++){
                if (items.get(i).get(1).equals(ruleValue)){
                    ans++;
                }
            }
        }else {
            for (int i = 0 ; i < items.size() ; i++){
                if (items.get(i).get(2).equals("name")){
                    ans++;
                }
            }
        }

        return ans;
    }
}
