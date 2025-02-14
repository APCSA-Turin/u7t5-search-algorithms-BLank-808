package com.example.project.Binary_Search;

public class BinarySearch {
    // implements binary search on the elements list for target,
    // and returns the index at which the target is found, or -1 if
    public static int binarySearch(int[] elements, int target) {
        if(elements.length==0){
            return -1;
        }
        int loopCounter = 0;
        int leftIdx =0;  
        int rightIdx =elements.length-1;

        while (leftIdx<=rightIdx) {  // TODO: determine this condition (hint: see slides 61-63)
        loopCounter++; // for testing

        //     System.out.print(loopCounter + " "); // for testing
        int middleIdx = ((rightIdx + leftIdx)/2); // TODO: determine what this should be
        if(elements[middleIdx]== target)  // TODO: write the rest of the code to compare middleIdx to the target
            {
            return middleIdx;
            }
        if(elements[middleIdx]>target)    //  and adjust leftIdx and rightIdx as appropriate (see slides if needed)
            {
                rightIdx=middleIdx-1;
            }else{
                leftIdx=middleIdx+1;
            }
        }
        return -1; // not found
    }

    public static void main(String[] args) {
        int[] elements = {1, 3, 5, 7, 9, 11, 13};
        int target = 13;
        int expectedIndex = -1; 
        int actualIndex = BinarySearch.binarySearch(elements, target);
        System.out.println(actualIndex);
    }
}
