package array;

public class MaxMin {

    static class Pair {
        int min;
        int max;
    }

    // Linear Method
    static Pair getMinMax (int arr[], int size) {
        Pair minMax = new Pair();
        int maxValue = minMax.max;
        int minValue = minMax.min;

        // case 1: if the size == 1
        if (size == 1) {
            minValue = arr[0];
            maxValue = arr[0];
            return minMax;
        }

        // case 2: size > 2
        if (arr[0] > arr[1]) {
            maxValue = arr[0];
            minValue = arr[1];
        } else {
            minValue = arr[0];
            maxValue = arr[1];
        }

        for (int i = 2; i < size; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            } else if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        minMax.min = minValue;
        minMax.max = maxValue;
        return minMax;

    }

    // Binary Method
    static Pair getMinMax (int arr[], int start, int end) {
        Pair minMax = new Pair();
        Pair minMaxLeft = new Pair();
        Pair minMaxRight = new Pair();

        // if array size is 1
        if (start == end) {
            minMax.min = arr[0];
            minMax.max = arr[0];
            return minMax;
        }

        // if array size is 2
        if (start + 1 == end) {
            if (arr[start] > arr[end]) {
                minMax.min = arr[end];
                minMax.max = arr[start];
            } else {
                minMax.min = arr[start];
                minMax.max = arr[end];
            }
            return minMax;
        }

        // if array size is more than 2
        int mid = (start + end) / 2;
        minMaxLeft = getMinMax(arr, start, mid);
        minMaxRight = getMinMax(arr, mid + 1, end);

        // find the min value between left and right
        if (minMaxLeft.min < minMaxRight.min) {
            minMax.min = minMaxLeft.min;
        } else {
            minMax.min = minMaxRight.min;
        }

        // find the max value between left and right
        if (minMaxLeft.max > minMaxRight.max) {
            minMax.max = minMaxLeft.max;
        } else {
            minMax.max = minMaxRight.max;
        }

        return minMax;
    }

    public static void main (String args[]) {
        int array[] = {13, 15, 3, 21, 17, 49, 29};
        int size = array.length;
        Pair minMax = getMinMax(array, 0, array.length-1);
        int maxValue = minMax.max;
        int minValue = minMax.min;
        System.out.println("Max Value: " + maxValue + ", Min Value: " + minValue);
    }
}
