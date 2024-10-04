package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class DividePlayersIntoTeamsOfEqualSkills {
    public static void main(String[] args) {

//        int []skill = {3,2,5,1,3,4};
        int []skill = {2 , 2 , 2 , 2 };

        System.out.println(dividePlayers(skill));

    }

    public static long dividePlayers(int[] skill) {
        // if skills is of two size just return the product
        if (skill.length == 2){
           return  (long) skill[0] * skill[1];
        }

        Arrays.sort(skill);

        // in hashmap we are going to add the <product> <sum>
        HashMap<Long , Long> map = new HashMap<>();
        map.put((long) ((long) skill[0] *skill[skill.length-1]), (long) (skill[0]+skill[skill.length-1]));
        int i = 1 ;
        int j = skill.length-2;


        while (i <= j){

            if (map.containsValue((long)skill[i]+skill[j])){
                map.put((long) ((long) skill[i] *skill[j]), (long) (skill[i]+skill[j]));
                i++;
                j--;
            }else {
                return -1;
            }



        }

        // calculate the product of sum of all the keys

        long sum_ans = 0L;
        for (Long key : map.keySet()){
            sum_ans+=key;
        }

        return sum_ans;
    }
}
