package CodingPractice.PracticeQuestions.Accolite;

public class CycleLengthFinder {
    public static int findCycleLength(int[] arr, int startIndex) {
        if (arr == null || arr.length == 0 || startIndex < 0 || startIndex >= arr.length) {
            return -1;
        }

        int slow = startIndex;
        int fast = startIndex;


        do {
            if (arr[fast] < 0 || arr[fast] >= arr.length || arr[arr[fast]] < 0 || arr[arr[fast]] >= arr.length) {
                return -1;
            }
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);


        int cycleLength = 0;
        do {
            fast = arr[fast];
            cycleLength++;
        } while (slow != fast);

        return cycleLength;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 0};
        int startIndex1 = 0;
        System.out.println(findCycleLength(arr1, startIndex1));

        int[] arr2 = {1, 2, 5, 9, 10, 2};
        int startIndex2 = 0;
        System.out.println(findCycleLength(arr2, startIndex2));
    }
}

