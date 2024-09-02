package CodingPractice.PracticeQuestions.Accolite;

public class MaxAverageSum {

    public static double maxSumAverage(int[] arr, int k) {
        double maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }
        double currentSum = maxSum;
        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum/k;
    }
        public static void main (String[]args){

            System.out.println(maxSumAverage(new int[]{1,12,-5,-6,50,3},4));
        }
    }
