package Algorithm;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AlgorithmUtilTest {

      private final AlgorithmUtil source;

      public AlgorithmUtilTest() {
            source = new AlgorithmUtil();
      }

      public static void main(String[] args) {
            AlgorithmUtilTest test = new AlgorithmUtilTest();

            test.bubbleSortTest();
            test.insertionSortTest();
            test.selectionSortTest();
            test.quickSortTest();
            test.mergeSortTest();
            test.countingSortTests();
            test.binarySearchTest();
            test.maxSumTest();
            test.kthLargestElementTest();
            test.sort0s1s2sTest();
            test.mooreITest();
            test.mooreIITest();
            test.sellStockTest();
            test.findInsertPositionTest();
            test.candyDistributionTest();
            test.gasStationTest();
            test.maximumSlindingTest();
            test.rotate90Test();
            test.jagglingLeftShiftTest();
            test.longestNonRepeatedSubStringTest();
            test.matchedStringTest();
            test.tripletsTest();
      }

      @Test
      public void bubbleSortTest(){

            int[] actualArr1 = {5,4,3,2,1};
            int[] actualArr2 = {4,32,9,4,0,0,2,32};
            source.bubbleSort(actualArr1);
            source.bubbleSort(actualArr2);
            int[] expectedArr1 = {1,2,3,4,5};
            int[] expectedArr2 = {0,0,2,4,4,9,32,32};
            assertArrayEquals(expectedArr1,actualArr1);
            assertArrayEquals(expectedArr2,actualArr2);
      }

      @Test
      public void insertionSortTest(){
            int[] actualArr1 = {5,4,3,2,1};
            int[] actualArr2 = {4,32,9,4,0,0,2,32};
            source.insertionSort(actualArr1);
            source.insertionSort(actualArr2);
            int[] expectedArr1 = {1,2,3,4,5};
            int[] expectedArr2 = {0,0,2,4,4,9,32,32};
            assertArrayEquals(expectedArr1,actualArr1);
            assertArrayEquals(expectedArr2,actualArr2);
      }

      @Test
      public void selectionSortTest(){
            int[] actualArr1 = {5,4,3,2,1};
            int[] actualArr2 = {4,32,9,4,0,0,2,32};
            source.selectionSort(actualArr1);
            source.selectionSort(actualArr2);
            int[] expectedArr1 = {1,2,3,4,5};
            int[] expectedArr2 = {0,0,2,4,4,9,32,32};
            assertArrayEquals(expectedArr1,actualArr1);
            assertArrayEquals(expectedArr2,actualArr2);
      }

      @Test
      public void quickSortTest(){
            int[] actualArr1 = {5,4,3,2,1};
            int[] actualArr2 = {4,32,9,4,0,0,2,32};
            source.quickSort(actualArr1,0,actualArr1.length-1);
            source.quickSort(actualArr2,0,actualArr2.length-1);
            int[] expectedArr1 = {1,2,3,4,5};
            int[] expectedArr2 = {0,0,2,4,4,9,32,32};
            assertArrayEquals(expectedArr1,actualArr1);
            assertArrayEquals(expectedArr2,actualArr2);
      }

      @Test
      public void mergeSortTest(){
            int[] actualArr1 = {5,4,3,2,1};
            int[] actualArr2 = {4,32,9,4,0,0,2,32};
            source.mergeSort(actualArr1,0,actualArr1.length-1);
            source.mergeSort(actualArr2,0,actualArr2.length-1);
            int[] expectedArr1 = {1,2,3,4,5};
            int[] expectedArr2 = {0,0,2,4,4,9,32,32};
            assertArrayEquals(expectedArr1,actualArr1);
            assertArrayEquals(expectedArr2,actualArr2);
      }

      @Test
      public void countingSortTests(){
            int[] actualArr1 = {5,4,3,2,1};
            int[] actualArr2 = {4,32,9,4,0,0,2,32};
            source.countingSort(actualArr1);
            source.countingSort(actualArr2);
            int[] expectedArr1 = {1,2,3,4,5};
            int[] expectedArr2 = {0,0,2,4,4,9,32,32};
            assertArrayEquals(expectedArr1,actualArr1);
            assertArrayEquals(expectedArr2,actualArr2);
      }

      @Test
      public void maxSumTest(){
            int[] arr1 = {1,-2,0,1,2,2,4,5};
            int expectedValue = 14;
            assertEquals(expectedValue,source.maxSum(arr1));
      }

      @Test
      public void kthLargestElementTest(){
            int[] arr = {4,32,9,4,0,0,2,32};
            int expectedValue1 = 9;
            int expectedValue2 = 2;
            int expectedValue3 = 32;
            int expectedValue4 = -1;

            assertEquals(expectedValue1,source.kthLargestElement(arr,3));
            assertEquals(expectedValue2,source.kthLargestElement(arr,6));
            assertEquals(expectedValue3,source.kthLargestElement(arr,1));
            assertEquals(expectedValue4,source.kthLargestElement(arr,-1));
      }

      @Test
      public void binarySearchTest() {
            int[] test = {1,24,56,78,90,100};
            int expectedValue1 = 1;
            int expectedValue2 = -1;
            int expectedValue3 = 5;

            assertEquals(expectedValue1,source.binarySearch(test,24));
            assertEquals(expectedValue2,source.binarySearch(test,57));
            assertEquals(expectedValue3,source.binarySearch(test,100));
      }

      @Test
      public void sort0s1s2sTest() {
            int[] arr = {0,1,2,2,1,1,0,2,1,0,0,0,0};
            int[] expectedValue = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2};
            source.sort0s1s2s(arr);
            assertArrayEquals(expectedValue,arr);
      }

      @Test
      public void mooreITest(){
            int[] arr1 = {1,2,2,2,2,4};
            int[] arr2 = {1,2,3,2,2,4};
            int candidate1 = source.mooreI(arr1);
            int candidate2 = source.mooreI(arr2);

            assertEquals(2,candidate1);
            assertEquals(-1,candidate2);
      }

      @Test
      public void mooreIITest(){
            int[] arr1 = {20, 30, 10, 10, 5, 4, 20, 1, 2};
            int[] arr2 = {10, 10, 20, 30, 10, 10};

            int[] expected1 = {-1,-1};
            int[] expected2 = {10,-1};

            assertArrayEquals(expected1,source.mooreII(arr1));
            assertArrayEquals(expected2,source.mooreII(arr2));
      }

      @Test
      public void sellStockTest(){
            int[] arr = {7,1,3,4,6,2};
            assertEquals(5,source.bestTimeToSellStock(arr));
      }

      @Test
      public void findInsertPositionTest() {
            int[] arr = {1,2,3,5};

            assertEquals(4,source.findInsertPosition(arr,6));
            assertEquals(0,source.findInsertPosition(arr,0));
            assertEquals(3,source.findInsertPosition(arr,4));
      }

      @Test
      public void candyDistributionTest() {
            int[] arr1 = {1,2,3,5};
            int[] arr2 = {1,2,3,4,5};
            int[] arr3 = {5,4,3,2,1};

            assertEquals(10, source.candyDistribution(arr1));
            assertEquals(15, source.candyDistribution(arr2));
            assertEquals(15, source.candyDistribution(arr3));
      }

      @Test
      public void gasStationTest() {
            List<Integer> gas1 = new ArrayList<>(List.of(1,2,3,4,5));
            List<Integer> cost1 = new ArrayList<>(List.of(3,4,5,1,2));

            List<Integer> gas2 = new ArrayList<>(List.of(2,3,4));
            List<Integer> cost2 = new ArrayList<>(List.of(3,4,3));

            assertEquals(3,source.gasStation(gas1,cost1));
            assertEquals(-1,source.gasStation(gas2,cost2));
      }

      @Test
      public void maximumSlindingTest(){
            int[] arr1 = {1,3,-1,-3,5,3,6,7};
            int[] arr2 = {1};
            List<Integer> result1 = new ArrayList<>(List.of(3,3,5,5,6,7));

            assertEquals(result1,source.maximumSlidingWindow(arr1,3));
            assertEquals(new ArrayList<>(List.of(1)),source.maximumSlidingWindow(arr2,1));
      }

      @Test
      public void squareSortedArrayTest(){
            int[] arr1 = {-4,-1,0,3,10};
            int[] arr2 = {-7,-3,2,3,11};

            int[] expected1 = {0,1,9,16,100};
            int[] expected2 = {4,9,9,49,121};

            assertArrayEquals(expected1,source.squaredSortedArray(arr1));
            assertArrayEquals(expected2,source.squaredSortedArray(arr2));
      }

      @Test
      public void rotate90Test() {
            int[][] arr1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
            int[][] expected1 = {{13,9,5,1},{14,10,6,2},{15,11,7,3},{16,12,8,4}};

            source.rotateArray90(arr1);
            assertArrayEquals(expected1,arr1);
      }

      @Test
      public void jagglingLeftShiftTest() {
            int[] arr1 = {1,2,3,4,5,6}; // 4 5 6 1 2 3
            int[] arr2 = {1,2,3,4,5,6,7,8}; //  5 6 7 8 1 2 3 4

            int[] expected1 = {4,5,6,1,2,3};
            int[] expected2 = {5,6,7,8,1,2,3,4};

            source.jagglingLeftSift(arr1,3);
            source.jagglingLeftSift(arr2,4);

            assertArrayEquals(expected1,arr1);
            assertArrayEquals(expected2,arr2);
      }

      @Test
      public void longestNonRepeatedSubStringTest(){
            assertEquals(3,source.longestNonRepeatedSubString("dvdf"));
            assertEquals(3,source.longestNonRepeatedSubString("apple"));
            assertEquals(4,source.longestNonRepeatedSubString("title"));
      }

      @Test
      public void matchedStringTest(){
            String txt1 = "onionsplonions";
            String pat1 = "onion";

            List<List<Integer>> expected1 = new ArrayList<>();
            expected1.add(new ArrayList<>(List.of(0,5)));
            expected1.add(new ArrayList<>(List.of(8,13)));

            assertEquals(expected1,source.matchedString(txt1,pat1));
      }

      @Test
      public void mergeIntervalTest(){

            int[][] arr1 = {{3,4},{5,6},{8,10},{2,5}};
            int[][] arr2 = {{8,10},{15,18},{2,3},{1,2},{1,3},{1,4},{2,5},{2,6},{3,6}};

            List<List<Integer>> expected1 = new ArrayList<>();
            expected1.add(new ArrayList<>(List.of(2,5)));
            expected1.add(new ArrayList<>(List.of(5,6)));
            expected1.add(new ArrayList<>(List.of(8,10)));

            List<List<Integer>> expected2 = new ArrayList<>();
            expected2.add(new ArrayList<>(List.of(1,6)));
            expected2.add(new ArrayList<>(List.of(8,10)));
            expected2.add(new ArrayList<>(List.of(15,18)));

            assertEquals(expected1,source.mergeInterval(arr1));
            assertEquals(expected2,source.mergeInterval(arr2));
      }

      @Test
      public void tripletsTest() {

            int[] arr1 = {-1,0,1,2,-1,-4};

            List<List<Integer>> expected1 = new ArrayList<>();
            expected1.add(new ArrayList<>(List.of(-1,-1,2)));
            expected1.add(new ArrayList<>(List.of(-1,0,1)));

            assertEquals(expected1,source.triplets(arr1));
      }

}