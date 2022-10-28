package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Program {
      // sorting Methods
      void bubbleSort(int[] arr);
      void insertionSort(int[] arr);
      void selectionSort(int[] arr);
      void quickSort(int[] arr,int lb,int ub);
      void mergeSort(int[] arr,int lb,int ub);
      void countingSort(int[] arr);
      void heapSort(int[] arr, int n);
      void shellsort(int[] arr);
      int[] relativeSort(int[] arr1, int[] arr2);

      // Arrays program
      List<List<Integer>> triplets(int[] arr);
      List<List<Integer>> mergeInterval(int[][] arr);
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
      void rotateRight(int[] arr, int k);
      void rotateArray90(int[][] arr);
      void sort0s1s2s(int[] arr);
      List<List<Integer>> matchedString(String txt,String pat);
      String formLargestElement(String[] str);
      List<Integer> waveArray(ArrayList<Integer> list);
      int firstRepeatingElement (int[] arr, int n);
      ArrayList<Integer> leadersInAnArray(int[] arr, int n);
      void reverseArrayInGroup(ArrayList<Integer> arr, int n, int k);
      int missingNumber(int[] arr, int n);
      int firstElementKTime(int[] arr,int n, int k);
      int removeDuplicatesInSortedArray(int[] arr);
      int findMaxConsecutiveOnes(int[] nums);
      boolean parenthesisChecker(String str);
      int findOnce(int[] arr, int n);
      void mergeSortedArrayI(int[] arr1, int[] arr2, int n, int m);
      void mergeSortedArrayII(int[] arr1, int[] arr2);
      int findLongestConseqSubseq(int[] arr, int n);
      int minimumIndexCharacter(String str, String pat);
      List<Integer> commonElements(ArrayList<Integer> list1, ArrayList<Integer> list2);
      List<Integer> findDuplicates(int[] arr1);
      boolean continuousSubarraySum(int[] arr, int sum);
      String findPairInTwoSortedArrays(int[] arr1, int[] arr2, int target);
      void rearrangeArrayAlternatively(int[] arr);
      void zigzagArray(int[] arr);
      int searchSortedArray(int[] arr, int target);
      int largestSubarrayZeroSum(int[] arr);
      int subarraySum(int[] arr, int target);
      ArrayList<Integer> mergeKSortedArrays(int[][] arr,int K);
      int trap(int[] arr);
      long findSwapValues(long A[], int n, long  B[], int m);
      boolean canArrange(int[] arr, int k);

      // Math program
      List<Integer> getRow(int rowIndex);
      List<List<Integer>> generate(int numRows);

      // String program
      String reverseWord (String S);
      String removeDuplicatesString(String S);
      boolean isAnagram(String s1, String s2);
      String flamesFun(String name1, String name2);
      String longestCommonPrefix(String[] strs);
      List<String> topKFrequent(String[] words, int k);
      List<List<String>> groupAnagrams(String[] strs);
      void setZeroes(int[][] matrix);

      // stack & queue
      List<Integer> maximumSlidingWindow(int[] arr, int k);
      ArrayList<Integer> countDistinctWindow(int[] arr, int n, int k);
      int orangesRotting(int[][] grid);
      boolean findsum(int arr[],int n);

      // Hashing program
      boolean isSubset(int[] arr1, int[] arr2);
      String unCommonCharacters (String s1, String s2);

      //Heap Program
      int lastStoneWeight(int[] arr);

      // DP Program
      long fibonacci(long n, HashMap<Long, Long> map);
      int gridTraveller(int r, int c, HashMap<String, Integer> map);
      int minPathSum(int[][] grid, int r, int c, HashMap<String, Integer> map);
      int coinChangeI(int[] coins, int amount);
      int coinChangeII(int[] coins, int amount);
      void combinationI(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> result);
      int knapsack0by1(int W, int wt[], int val[], int n);
      int longestCommonSubsequence(String text1, String text2);
      int longestCommonSubstring(String text1, String text2);
      int longestPalindromeSubsequence(String str);
      int formPalindromeUsingMinimumInsertion(String str);
      int maxProfit(int[] prices);

      // greedy program
      int activitySelection(int[] start, int[] end);
      int minimumPlatform(int[] arr, int[] dep);

      //backtracking
      void backtrack(List<String> result, String current_str, int open,int close, int max);
      void permutationI(int[] nums, int l, int r, List<List<Integer>> result);
}
