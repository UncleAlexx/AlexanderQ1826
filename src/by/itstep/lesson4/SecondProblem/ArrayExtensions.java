package by.itstep.lesson4.SecondProblem;

import java.util.Arrays;

public class ArrayExtensions {

    private final boolean sortOrder;

    public ArrayExtensions(boolean asc){
        sortOrder = asc;
    }


    public void sort(int[] numbers){
        int elemToSwapIndex;
        int nullCheckLength = zeroLengthIfNull(numbers);
        for (int i = 0; i < nullCheckLength- 1; i++) {
            elemToSwapIndex = i;
            for (int j = i + 1; j < nullCheckLength ; j++) {
                if(getComparisonBySortOrder(numbers[j], numbers[i])) {
                   elemToSwapIndex = j;
                }
            }
            if(elemToSwapIndex != i){
               swap(numbers, elemToSwapIndex, i);
            }
        }
    }

    public int max (int[] buffer){
        int upperBound = zeroLengthIfNull(buffer);
        int max = - 1;
        for (int i = 0; i < upperBound; i++) {
            if( buffer[i] > max)
                max = buffer[i];
        }
        return max;
    }

       public int getIndexByElem (int[] buffer, int elem) {
        Arrays.sort(buffer);
        int mid;
        int currentRight = buffer == null ? 0 : buffer.length - 1;

        int currentLeft = 0;
        while (currentRight  >= currentLeft) {

            mid = currentLeft + (currentRight - currentLeft) / 2;
            if (elem == buffer[mid]) {
                return mid;
            }
            else if (elem < buffer[mid]) {
                currentRight = mid - 1;
            } else {
                currentLeft = mid + 1;
            }
        }
        return -1;
    }

    private boolean getComparisonBySortOrder(int a, int b){
        return sortOrder? a < b : a > b;
    }

    private int zeroLengthIfNull(int[] buffer)
    {
        return  buffer == null ? 0 : buffer.length;
    }

    private void swap(int[] buffer, int firstIndex, int secondIndex){
        int temp = buffer[firstIndex];
        buffer[firstIndex] = buffer[secondIndex];
        buffer[secondIndex] = temp;
    }
}
