package Arrays;

public class FarthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int distance = 0;
        for (int i = 0 ; i < heights.length ; i++){
            if (heights[i] > heights[i+1]){
                distance++;
            }
            if (heights[i] < heights[i+1]){
                if (ladders+bricks >= heights[i+1]){
                    distance++;
                }
            }
        }

        return distance;
    }
}
