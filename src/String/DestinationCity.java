package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DestinationCity {
    public static void main(String[] args) {

    }

    public String destCity(List<List<String>> paths) {
        HashSet<String> starting_cities = new HashSet<>();

        for (List<String> path : paths){
            starting_cities.add(path.get(0));
        }

        for (List<String> path : paths){
            // match the destination cities with starting_cities if not matched then just return
            String destination = path.get(1);
            if (!starting_cities.contains(destination)){
                return destination;
            }
        }

        return "";

    }


}
