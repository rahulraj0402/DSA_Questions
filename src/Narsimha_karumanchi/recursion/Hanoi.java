package Narsimha_karumanchi.recursion;

public class Hanoi {
    public static void main(String[] args) {
        int n = 3;
        solveHanoi(n , 'A' , 'C','B');
    }

    /**
     * Algorithm : we have 3 towers A , B , C
     * CASE 1 : one disk - move from A to C | solved
     * CASE 2 : two disk - move top disk to B , move bottom disk to C , move disk from B -> C
     * CASE 3 : THREE disk - [ we know how to move top 2 disk , so we will move to B , then last disk from A-> C ,
     *
     * Algo -
     * 1) Move (n-1) disk from A->B using C
     * 2) Move disk A->C
     * 3) Move (n-1) disk B->c
     *
     */

    public static void solveHanoi(int n, char fromRod, char toRod, char auxRod) {
        // Base case: If there's only one disk, move it directly from 'fromRod' to 'toRod'
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }

        // Move the top n-1 disks from 'fromRod' to 'auxRod' using 'toRod' as auxiliary
        solveHanoi(n - 1, fromRod, auxRod, toRod);

        // Move the nth disk from 'fromRod' to 'toRod'
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);

        // Move the n-1 disks from 'auxRod' to 'toRod' using 'fromRod' as auxiliary
        solveHanoi(n - 1, auxRod, toRod, fromRod);
    }
}
