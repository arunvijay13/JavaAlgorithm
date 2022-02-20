package Algorithm;

import java.util.List;

public interface Program {
      // sorting Methods
      void bubbleSort(int[] arr);
      void insertionSort(int[] arr);
      void selectionSort(int[] arr);
      void quickSort(int[] arr,int lb,int ub);
      void mergeSort(int[] arr,int lb,int ub);
      void countingSort(int[] arr);

      //Dynamic Programming Methods
      List<List<Integer>> triplets(int[] arr);
      List<List<Integer>> mergeInterval(int[][] arr);
      List<Integer> maximumSlidingWindow(int[] arr,int k);
      int longestNonRepeatedSubString(String txt);
      int[] squaredSortedArray(int[] arr);
      int maxSum(int[] arr);
      int mooreI(int[] arr);
      int[] mooreII(int[] arr);
      int bestTimeToSellStock(int[] arr);
      int findInsertPosition(int[] arr,int element);
      int binarySearch(int[] arr,int target);
      int kthLargestElement(int[] arr,int k);
      int gasStation(List<Integer> gas,List<Integer> cost);
      int candyDistribution(int[] studentsRating);
      void jagglingLeftSift(int[] arr,int k);
      void rotateArray90(int[][] arr);
      void sort0s1s2s(int[] arr);
      List<List<Integer>> matchedString(String txt,String pat);

}
